package com.cognitivescale.poc.bank.common.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sumdwive
 * To create connection pool object using property file or input as method argument
 * I did not use spring for reading properties file so that connection pool code can be generic to all java applications
 *
 */
public class JDBCConnectionPoolFactory {
	
	private static final Logger logger = Logger.getLogger(JDBCConnectionPoolFactory.class.getCanonicalName());
	
	public static synchronized ConnectionPool createConnectionPool(String dbUrl, String dbUser, String dbPassword, String driverClassName) {
		ConnectionPool connectionPool = null;
		try {
			connectionPool = new ConnectionPool(dbUrl, dbUser, dbPassword, driverClassName);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return connectionPool;
	}
	
	public static synchronized ConnectionPool createConnectionPool(int maxPoolSize, int initialPoolSize, String dbUrl, String dbUser, String dbPassword, String driverClassName, int expirationTime) {
		ConnectionPool connectionPool = null;
		try {
			connectionPool = new ConnectionPool(maxPoolSize, initialPoolSize, dbUrl, dbUser, dbPassword, driverClassName, expirationTime);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return connectionPool;
	}
	
	public static synchronized ConnectionPool createConnectionPool(String dbPropertiesFileName) {
		ConnectionPool pool = null;
		
		Properties prop = new Properties();
    	InputStream input = null;
    	input = JDBCConnectionPoolFactory.class.getClassLoader().getResourceAsStream(dbPropertiesFileName);
    	if(input==null){
    		logger.log(Level.SEVERE, "Sorry, unable to find " + dbPropertiesFileName);
    		throw new IllegalArgumentException("Sorry, unable to find " + dbPropertiesFileName + " in classpath.");
	} else {
		
		//load a properties file from class path, inside static method
		try {
			prop.load(input);
			
			String maxPoolSizeStr = prop.getProperty("maxPoolSize");
			maxPoolSizeStr = maxPoolSizeStr!= null?maxPoolSizeStr:"0";
			int maxPoolSize = Integer.parseInt(maxPoolSizeStr);
			String initialPoolSizeStr = prop.getProperty("initialPoolSize");
			initialPoolSizeStr = initialPoolSizeStr!= null?initialPoolSizeStr:"0";
			int initialPoolSize = Integer.parseInt(initialPoolSizeStr);
			String dbUrl = prop.getProperty("dbUrl");
			String dbUser = prop.getProperty("dbUser"); 
			String dbPassword = prop.getProperty("dbPassword");
			String driverClassName = prop.getProperty("driverClassName");
			String expirationTimeStr = prop.getProperty("expirationTime");
			expirationTimeStr = expirationTimeStr!= null?expirationTimeStr:"0";
			int expirationTime = Integer.parseInt(expirationTimeStr);
			
			if(maxPoolSizeStr != null && initialPoolSizeStr != null && expirationTimeStr != null) {
				pool = createConnectionPool(maxPoolSize, initialPoolSize, dbUrl, dbUser, dbPassword, driverClassName, expirationTime);
			} else {
				pool = createConnectionPool(dbUrl, dbUser, dbPassword, driverClassName);
			}
			
			
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
		
		
		return pool;
	}
	
}
