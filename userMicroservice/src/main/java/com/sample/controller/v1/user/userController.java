package com.sample.controller.v1.user;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.UserDto;
import com.sample.dto.http.response.DataResponse;
import com.sample.dto.http.response.RestResponse;
import com.sample.dto.http.response.StatusCode;
import com.sample.service.UserServices;



@RestController
@RequestMapping("/api/v1/")
public class userController {

	private static final Logger logger = LoggerFactory.getLogger(userController.class);

	@Autowired
	UserServices userServices;

	@RequestMapping(value = "/user/", method = RequestMethod.POST , produces = "application/json")
	public RestResponse userRegister(@RequestBody UserDto userDto) {
		try {
			RestResponse response = userServices.register(userDto);
			return response;
		}catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, e.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST , produces = "application/json")
	public RestResponse userLogin(@RequestBody UserDto userDto) {
		try {
			RestResponse response = userServices.login(userDto);
			return response;
		}catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, e.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET , produces = "application/json")
	public RestResponse userProfile(String userId) {
		try {
			RestResponse response = userServices.viewProfile(UUID.fromString(userId));
			return response;
		}catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, e.getMessage(), null);
		}
	}

}
