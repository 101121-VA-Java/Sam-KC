package com.revature;

import com.revature.models.User;
import com.revature.services.UserAuth;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserAuthController {
	
    public static void loginUser(Context ctx) {   
    	
    	UserAuth ua = new UserAuth();
    	User u = ctx.bodyAsClass(User.class);   	
    	String authResult = ua.loginUserByEmail(u);
    	
    	if (authResult.equals("loggedin")) {
    	ctx.status(HttpCode.OK);
    	ctx.header("Access-Control-Expose-Headers","authToken");
    	String token = createToken(u);
    	ctx.header("authToken", token);
    	ctx.result(String.valueOf(u.getRole().getRoleId()));    	
    	}
    	else {
    	ctx.result(authResult);
    	ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }
    
    public static String createToken(User u) {    	
    	UserAuth ua = new UserAuth();    	
    	User userInfo = ua.getUserbyEmail(u.getEmail());    	
    	if (userInfo != null) {
    	String token = userInfo.getUsername() + ":" + userInfo.getPassword();
    	return token;
    	}
    	return null;
    }
    
    public static boolean checkToken(Context ctx) {
    	try {
    	String token = ctx.header("authToken");    	
    	String[] tokens = token.split(":");
    	User u = new User();
    	u.setUsername(tokens[0]);
    	u.setPassword(tokens[1]);    	
    	UserAuth ua = new UserAuth();    	  	
    	String authResult = ua.loginUser(u.getUsername(), u.getPassword());    	
    	if (authResult.equals("loggedin")) {
    	return true;	
    	}
    	}
    	catch (Exception e) {};
    	return false;
    }
    

}
