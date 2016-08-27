package com.cognitivescale.poc.bank.common.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sumdwive
 * ObjectPool pattern implementation
 * I wrote this class , just to implement basic connection pool behavior.
 * for real time usage hikari connection pool is currently best performing jdbc connection pool librrary
 */
public class ConnectionPool {

    private static final Logger logger = Logger.getLogger(ConnectionPool.class.getCanonicalName());

    private ConcurrentHashMap<Connection,Long> lockedPool;
    private ConcurrentHashMap<Connection,Long> unlockedPool;
    /** Maximum number of connections that the pool can have */
    private int maxPoolSize = 10;
    /** Number of connections that should be created initially */
    private int initialPoolSize = 5;
    /** Number of connections generated so far */
    private AtomicInteger currentPoolSize;

    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private long expirationTime = 30000; // 30 seconds
    
    private BlockingQueue<Connection> pool ;
    
    Runnable cleanUpThread = null;

    public ConnectionPool(String dbUrl, String dbUser, String dbPassword, String driverClassName) throws ClassNotFoundException, SQLException {
		super();
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		
		initPooledConnections(driverClassName);
        
        launchCLeanUpThread();
	}

	public ConnectionPool(int maxPoolSize, int initialPoolSize, String url, String username,
                          String password, String driverClassName, long expirationTime) throws ClassNotFoundException, SQLException {

        if( (initialPoolSize > maxPoolSize) || initialPoolSize<1 || maxPoolSize <1 ) {
            throw new IllegalArgumentException("Invalid pool size parameters");
        }
        
        // default max pool size to 10
        this.maxPoolSize = maxPoolSize>0 ? maxPoolSize : 10;
        this.initialPoolSize = initialPoolSize;
        this.dbUrl = url;
        this.dbUser = username;
        this.dbPassword = password;
        if(this.expirationTime < expirationTime) {
        	this.expirationTime = expirationTime;
        }
        
        this.lockedPool = new ConcurrentHashMap<Connection, Long>(maxPoolSize);
        this.unlockedPool = new ConcurrentHashMap<Connection, Long>(maxPoolSize);
        this.pool = new LinkedBlockingQueue<Connection>(maxPoolSize);

        initPooledConnections(driverClassName);
        
        launchCLeanUpThread();

    }

	private void launchCLeanUpThread() {
		cleanUpThread = () -> { 
        	cleanUpIdleConnections();
        	// Now sleep for 1 minute 
            try {
				Thread.sleep(60000 * 1);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
        };
        
        // start the cleanUp thread
        new Thread(cleanUpThread).start();
	}

	private void cleanUpIdleConnections() {
		long now = System.currentTimeMillis();
		Connection o;
		if (unlockedPool.size() > 0) {
			Enumeration<Connection> e = unlockedPool.keys();
			while (e.hasMoreElements()) {
				o = e.nextElement();
				if ((now - ((Long) unlockedPool.get(o)).longValue()) > expirationTime) {
					// object has expired
					unlockedPool.remove(o);
					pool.remove(o);
					expire(o);
					o = null;
				} else {
					if (!validate(o)) {
						// object failed validation
						unlockedPool.remove(o);
						pool.remove(o);
						expire(o);
						o = null;
					}
				}
			}
		}

	}

	private void initPooledConnections(String driverClassName)
            throws ClassNotFoundException, SQLException {

        // 1. Attempt to load the driver class
        Class.forName(driverClassName);

        // 2. Create and pool connections
        for(int i=0; i<initialPoolSize; i++) {
            openAndPoolConnection();
        }
    }

    private synchronized void openAndPoolConnection() throws SQLException {
        if(currentPoolSize.get() == maxPoolSize) { return; }

        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        PooledConnection pooledConnection = new PooledConnection(conn, this);
		unlockedPool.put(pooledConnection, System.currentTimeMillis());
        pool.offer(pooledConnection);
        currentPoolSize.incrementAndGet();

        logger.log(Level.FINE, "Created connection {0}, currentPoolSize={1}, maxPoolSize={2}",
                   new Object[]{conn, currentPoolSize, maxPoolSize});
    }

    public Connection borrowConnection() throws InterruptedException, SQLException {
    	
		long now = System.currentTimeMillis();
		Connection o;
		if (unlockedPool.size() > 0) {
			Enumeration<Connection> e = unlockedPool.keys();
			while (e.hasMoreElements()) {
				o = e.nextElement();
				if ((now - ((Long) unlockedPool.get(o)).longValue()) > expirationTime) {
					// object has expired
					unlockedPool.remove(o);
					pool.remove(o);
					expire(o);
					o = null;
				} else {
					if (validate(o)) {
						unlockedPool.remove(o);
						lockedPool.put(o, new Long(now));
						pool.remove(o);
						return (o);
					} else {
						// object failed validation
						unlockedPool.remove(o);
						pool.remove(o);
						expire(o);
						o = null;
					}
				}
			}
		}
		// no objects available, create a new one

        if(currentPoolSize.get() < maxPoolSize) { openAndPoolConnection(); }
        // Borrowing thread will be blocked till connection
        // becomes available in the queue
        o = pool.take();
        unlockedPool.remove(o);
        lockedPool.put(o, new Long(now));
		return o;
    }

    public void surrenderConnection(Connection conn) {
        if(!(conn instanceof PooledConnection)) { return; }
        lockedPool.remove(conn); // offer() as we do not want to go beyond capacity
        unlockedPool.put(conn, System.currentTimeMillis());
    }
    
    void expire( Object o )
    {
       try
       {
          ( ( Connection ) o ).close();
       }
       catch( SQLException e )
       {
    	   logger.log(Level.SEVERE, e.getMessage());
       }
    }
    
    boolean validate( Object o )
    {
       try
       {
          return( ! ( ( Connection ) o ).isClosed() );
       }
       catch( SQLException e )
       {
    	   logger.log(Level.SEVERE, e.getMessage());
          return( false );
       }
    }
    
    @Override
    protected void finalize() throws Throwable {
    	super.finalize();
    	shutDownConnectionPool();
    }

	public void shutDownConnectionPool() throws SQLException {
		if(lockedPool != null) {
			for(Connection key : lockedPool.keySet()){
	    		key.close();
	    		lockedPool.remove(key);
	    	}
		}
		
		if(unlockedPool != null) {
			for(Connection key : unlockedPool.keySet()){
	    		key.close();
	    		unlockedPool.remove(key);
	    		pool.remove(key);
	    	}
		}
    	
    	lockedPool = null;
    	unlockedPool = null;
    	pool = null;
	}
}