package com.sample.serviceImp;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.sample.dto.UserDto;
import com.sample.dto.http.response.DataResponse;
import com.sample.dto.http.response.Messages;
import com.sample.dto.http.response.RestResponse;
import com.sample.dto.http.response.StatusCode;
import com.sample.dtoToModel.UserDtoToModel;
import com.sample.model.User;
import com.sample.modelToDto.UserModelToDto;
import com.sample.service.UserServices;
import com.sample.validate.Validations;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UserServiceImp implements UserServices{

	@Autowired
	CassandraTemplate cassandraTemplate;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@Value("${EXPIRATION_TIME}") private String expireTime;
	@Value("${SECRET}") private String secret;

	@Override
	public RestResponse register(UserDto userDto) {

		User user = null;
		try {

			user = this.findByEmail(userDto.getEmail());

			if (user != null) {
				return new DataResponse(StatusCode.ALREADY_EXISTS, Messages.EMAIL_ALREADY_EXISTS, null);
			} else {

				Validations validations = new Validations();

				RestResponse rs = null; 

				String [] requestArrayForAll =  {"fullName", "email" , "password" };    

				rs = validations.validate(userDto, requestArrayForAll);

				if (rs != null) {
					return rs;
				}

				user = new User();

				UserDtoToModel userDtoToModel = new UserDtoToModel();

				DataResponse dataResponse = (DataResponse) userDtoToModel.dtoToModel(userDto);

				if (dataResponse.getStatus() != StatusCode.SUCCESS) {
					return new DataResponse(StatusCode.ERROR, Messages.ERROR_MESSAGE, null);
				} else {

					user = (User) dataResponse.getData();
					user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
					userDto.setId(user.getId());
					userDto.setToken(this.getToken(user.getId()));
					
					cassandraTemplate.insert(user);

					return new DataResponse(StatusCode.SUCCESS, Messages.SIGN_UP_SUCESSFULLY, userDto);
				}

			}

		} catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, Messages.ERROR_MESSAGE, null);
		}

	}

	public User findByEmail(String email) {
		try {

			Select select = QueryBuilder.select().from("user");
			select.where(QueryBuilder.eq("email", email.toLowerCase()));//..			
			User user = cassandraTemplate.selectOne(select, User.class);		

			return user;			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// generate token from user id for login , verify account and forgot password 
	private String getToken(UUID uuid) {

		String userId = uuid+"";

		System.out.println(userId);

		String token = Jwts.builder()
				.setSubject(userId)
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expireTime)))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();

		return token;
	}

	@Override
	public RestResponse login(UserDto userDto) {
		User user = null;
		try {

			user = this.findByEmail(userDto.getEmail());

			if (user != null) {
				return new DataResponse(StatusCode.ALREADY_EXISTS, Messages.EMAIL_ALREADY_EXISTS, null);
			} else {
				
				if (!bCryptPasswordEncoder.matches(userDto.getPassword(), user.getPassword())) {
					return new DataResponse(StatusCode.INVALID_CREDENTIALS_STATUS, Messages.INCORRECT_CREDENTIALS, null);
				} else {
					
					UserModelToDto userModelToDto =new UserModelToDto();
					
					DataResponse dataResponse = (DataResponse) userModelToDto.dtoToModel(user);
					
					UserDto userDto2 = (UserDto) dataResponse.getData();
					
					userDto2.setToken(this.getToken(user.getId()));
					
					return new DataResponse(StatusCode.SUCCESS, Messages.LOGIN_SUCESSFULLY, userDto2);
					
				}
			}
		}catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, Messages.ERROR_MESSAGE, null);
		}
	}

	@Override
	public RestResponse viewProfile(UUID id) {
		User user;
		
		try {
			
			user = this.findByUserId(id);
			
			UserModelToDto userModelToDto =new UserModelToDto();
			
			DataResponse dataResponse = (DataResponse) userModelToDto.dtoToModel(user);
			
			UserDto userDto2 = (UserDto) dataResponse.getData();
						
			return new DataResponse(StatusCode.SUCCESS, Messages.SUCESS, userDto2);
			
		} catch (Exception e) {
			return new DataResponse(StatusCode.ERROR, Messages.ERROR_MESSAGE, null);
		}
		
	}
	
	public User findByUserId(UUID id) {
		try {

			Select select = QueryBuilder.select().from("user");
			select.where(QueryBuilder.eq("id", id));//..			
			User user = cassandraTemplate.selectOne(select, User.class);		

			return user;			

		} catch (Exception e) {
			return null;
		}
	}

}


