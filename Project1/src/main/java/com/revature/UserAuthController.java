package com.revature;

import com.revature.models.User;
import com.revature.services.UserAuth;

import io.javalin.http.Context;

public class UserAuthController {
	
    public static void loginUser(Context ctx) {   
    	
    	UserAuth ua = new UserAuth();
    	User u = ctx.bodyAsClass(User.class);   	
    	String authResult = ua.loginUser(u.getUsername(), u.getPassword());
    
    }
    

}
