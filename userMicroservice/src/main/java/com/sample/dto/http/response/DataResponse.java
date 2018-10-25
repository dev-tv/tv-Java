package com.sample.dto.http.response;

public class DataResponse extends StatusResponse{
	
	protected Object data;

	public DataResponse() {
		
	}

	public DataResponse(int status, String message , Object data) {
		super.status = status;
		this.message = message;
		this.data = data;
		
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
