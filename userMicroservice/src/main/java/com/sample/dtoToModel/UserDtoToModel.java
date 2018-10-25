package com.sample.dtoToModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.dto.UserDto;
import com.sample.dto.http.response.DataResponse;
import com.sample.dto.http.response.RestResponse;
import com.sample.dto.http.response.StatusCode;
import com.sample.model.User;

public class UserDtoToModel {

	private ObjectMapper mapper = new ObjectMapper();

	public RestResponse dtoToModel(UserDto userDto) {

		try {
			User user = mapper.convertValue(userDto, User.class);

			return new DataResponse(StatusCode.SUCCESS, "", user);
		}catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, "", null);
		}

	}

}
