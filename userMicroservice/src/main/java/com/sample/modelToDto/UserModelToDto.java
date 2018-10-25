package com.sample.modelToDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.dto.UserDto;
import com.sample.dto.http.response.DataResponse;
import com.sample.dto.http.response.RestResponse;
import com.sample.dto.http.response.StatusCode;
import com.sample.model.User;

public class UserModelToDto {
	
	private ObjectMapper mapper = new ObjectMapper();

	public RestResponse dtoToModel(User user) {
		
		try {
			UserDto userDto = mapper.convertValue(user, UserDto.class);
			
			return new DataResponse(StatusCode.SUCCESS, "", userDto);
		}catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, "", null);
		}
		
	}


	
}
