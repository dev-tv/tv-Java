package com.sample.routes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MSRoutes {
	
	public static final Map<String,String> USERMS;
	
	public static final String USERMS_BASE = "http://localhost:8070/user-ms";
	static {
		Map<String,String> tmpMap = new HashMap<String,String>();
		tmpMap.put("LOGIN", USERMS_BASE+"/user/login/");
		
		tmpMap.put("SIGN_UP", USERMS_BASE+"/user/");

		tmpMap.put("USER_PROFILE", USERMS_BASE+"/user/");

		USERMS = Collections.unmodifiableMap(tmpMap);
	}
}
