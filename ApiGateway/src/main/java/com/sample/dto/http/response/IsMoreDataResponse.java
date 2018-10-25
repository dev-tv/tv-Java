package com.sample.dto.http.response;

public class IsMoreDataResponse extends DataResponse implements RestResponse{
	
	protected String isMore;

	public IsMoreDataResponse() {
		
	}

	public IsMoreDataResponse(int status, Object data, String isMore) {
		
		super.status = status;
		super.data = data;
		this.isMore = isMore;
	}

	public String getIsMore() {
		return isMore;
	}

	public void setIsMore(String isMore) {
		this.isMore = isMore;
	}
	
	

}
