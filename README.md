# tv-Java

ApiGateway
	   |
	   |----/src/main/
	   |	|---- /java/com/sample/
	   |					|---- application
	   |					|		|---- ApigatewayApplication.java
	   |					|
	   |					|---- config
	   |					|		|---- SwaggerConfig.java
	   |					|
	   |					|---- controller
	   |					|		|---- /v1/user
	   |					|				|---- userController.java
	   |					|
	   |					|---- dto
	   |					|		|---- userDto.java
	   |					|
	   |					|---- dto
	   |					|		|----http/response
	   |					|				|---- DataResponse.java
	   |					|				|---- IsMoreDataResponse.java
	   |					|				|---- Messages.java
	   |					|				|---- RestResponse.java
	   |					|				|---- StatusCode.java
	   |					|				|---- StatusResponse.java
	   |					|
	   |					|---- http
	   |					|		|----filter
	   |					|				|---- CORSfilter.java
	   |	    			|
	   |					|---- model
	   |					|		|---- UserAuthToken.java
	   |					|
	   |					|---- model
	   |					|		|----support		
	   |					|			|---- IbSupport.java
	   |	    			|
	   |					|---- routes
	   |					|		|---- MSRoutes.java
	   |					|
	   |					|---- service
	   |					|		|---- AuthTokenService.java
	   |					|		|---- UserServices.java // connect to other(user) micro-services
	   |		
	   |	|---- resources
	   |			|---- application.properties.java




	   userMicroservice
	   |
	   |----/src/main/
	   |	|---- /java/com/sample/
	   |					|---- application
	   |					|		|---- ApigatewayApplication.Java
	   |					|
	   |					|---- controller
	   |					|		|---- /v1/user
	   |					|				|---- userController.java
	   |					|
	   |					|---- dto
	   |					|		|---- userDto.java
	   |					|
	   |					|---- dto
	   |					|		|----http/response
	   |					|				|---- DataResponse.java
	   |					|				|---- IsMoreDataResponse.java
	   |					|				|---- Messages.java
	   |					|				|---- RestResponse.java
	   |					|				|---- StatusCode.java
	   |					|				|---- StatusResponse.java
	   |					|
	   |					|---- dtoToModel
	   |					|		|----UserDtoToModel.java
	   |	    			|
	   |					|---- model
	   |					|		|---- User.java
	   |					|
	   |					|		|----support		
	   |					|				|---- IbSupport.java
	   |					|
	   |					|---- modelToDto
	   |					|		|---- UserModelToDto.java
	   |					|
	   |					|---- service
	   |					|		|---- UserService.java
	   |					|
	   |					|---- serviceImp
	   |					|		|---- UserService.java
	   |					|
	   |					|---- validate
	   |					|		|---- Validations.java
	   |		
	   |	|---- resources
	   |			|---- application.properties.java
