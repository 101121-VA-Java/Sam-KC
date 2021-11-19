package com.revature;

import com.revature.models.User;
import com.revature.services.UserAuth;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserAuthController {
	
    public static void loginUser(Context ctx) {   
    	
    	UserAuth ua = new UserAuth();
    	User u = ctx.bodyAsClass(User.class);   	
    	String authResult = ua.loginUserByEmail(u.getEmail(), u.getPassword());
    	ctx.result(authResult);
    	if (authResult.equals("loggedin")) {
    	ctx.status(HttpCode.OK);
    	}
    	else {
    	ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }
    

}
