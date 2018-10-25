package com.sample.dto.http.response;


public class StatusResponse implements RestResponse{
	
	protected int status;
	
	protected String message;

	public StatusResponse(int status) {
		this.status = status;
	}

	public StatusResponse() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
