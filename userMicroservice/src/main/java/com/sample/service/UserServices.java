package com.sample.service;

import java.util.UUID;

import com.sample.dto.UserDto;
import com.sample.dto.http.response.RestResponse;

public interface UserServices {

	public RestResponse register(UserDto userDto);

	public RestResponse login(UserDto userDto);

	public RestResponse viewProfile(UUID id);

}
