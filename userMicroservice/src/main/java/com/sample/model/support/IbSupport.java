package com.sample.model.support;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class IbSupport {
	
	private long createdAt = System.currentTimeMillis();
	
	private long updatedAt = System.currentTimeMillis();
	
	private boolean isDeleted;

	public IbSupport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IbSupport(long createdAt, long updatedAt, boolean isDeleted) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "IbSupport [createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isDeleted=" + isDeleted + "]";
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty(value = "isDeleted")
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
