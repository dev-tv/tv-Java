package com.sample.service;

import static com.sample.routes.MSRoutes.USERMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sample.dto.UserDto;
import com.sample.dto.http.response.DataResponse;
import com.sample.dto.http.response.RestResponse;
import com.sample.dto.http.response.StatusCode;;

public class UserServices {
	
	@Autowired
	private RestTemplate restTemplate;
	

	public RestResponse register(UserDto userDto) {

		 try{	    		    
			    HttpEntity<UserDto> request = new HttpEntity<>(userDto);
			    		    
			    ResponseEntity<DataResponse> response = restTemplate
			      .exchange(USERMS.get("SIGN_UP"), HttpMethod.POST, request, DataResponse.class);
			    
			    DataResponse res=  response.getBody();
			    
			    return res;
		 }catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, "", null);
		}
	}

	public RestResponse login(UserDto userDto) {
	
		try{	    		    
			    HttpEntity<UserDto> request = new HttpEntity<>(userDto);
			    		    
			    ResponseEntity<DataResponse> response = restTemplate
			      .exchange(USERMS.get("LOGIN"), HttpMethod.POST, request, DataResponse.class);
			    
			    DataResponse res=  response.getBody();
			    
			    return res;
		 }catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, "", null);
		}
	}

	public RestResponse viewProfile(String  userId) {
		
		try{	    		    
		    HttpEntity<String> request = new HttpEntity<>(userId);
		    		    
		    ResponseEntity<DataResponse> response = restTemplate
		      .exchange(USERMS.get("PROFILE"), HttpMethod.GET, request, DataResponse.class);
		    
		    DataResponse res=  response.getBody();
		    
		    return res;
	 }catch (Exception e) {
		return new DataResponse(StatusCode.ERROR, "", null);
	}
	}
	
	

}
