package com.cognitivescale.poc.bank.data.rdb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class RDBBase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	protected long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_timestamp", nullable = false)
	protected Date createdTimestamp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_timestamp", nullable = false)
	protected Date modifiedTimestamp;
	@Column(name = "created_userid", nullable = false)
	protected String createdUserId;
	@Column(name = "modified_userid", nullable = false)
	protected String modifiedUserId;
	
	protected RDBBase(long id) {
		super();
		this.id = id;
	}

	public RDBBase() {
		super();
		this.createdTimestamp = new Date();
		this.modifiedTimestamp = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	
}
