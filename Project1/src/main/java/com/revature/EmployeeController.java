package com.revature;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.EmployeeService;

import io.javalin.http.Context;

public class EmployeeController {
	
    public static void getEmployeeById(Context ctx) {    
    	

    }
    
    public static void submitReimbRequest(Context ctx) {    
    	ctx.result("list");
    }
    public static void updateInfo(Context ctx) {    
    	ctx.result("list");
    }
    
    public static void viewInfo(Context ctx) {    
    	if (UserAuthController.checkToken(ctx) == true) { 
    	EmployeeService es = new EmployeeService();
    	User u = es.viewAccountInfo(splitToken(ctx)[0]);
    	GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String JSONObject = gson.toJson(u);
		ctx.result(JSONObject);
    	}
    	else {
    		ctx.result("false");
    	}
    	
    }
    public static void viewResolvedRequest(Context ctx) {    
    	if (UserAuthController.checkToken(ctx) == true) { 
        	
    		EmployeeService es = new EmployeeService();
    		User u = new User();
    		u.setUsername(splitToken(ctx)[0]);
    		ArrayList<Reimbursement> ar = es.viewResolvedReimb(u);
    		// get list of pending request
    		//set status code
    		// set JSON
    		GsonBuilder gsonBuilder = new GsonBuilder();
    		Gson gson = gsonBuilder.create();
    		String JSONObject = gson.toJson(ar);

    		ctx.result(JSONObject);
    	}
    	else {
    		ctx.result("false");
    	}
    }
    public static void viewPendingRequest(Context ctx) {    
    	

    	if (UserAuthController.checkToken(ctx) == true) { 
    	
    		EmployeeService es = new EmployeeService();
    		User u = new User();
    		u.setUsername(splitToken(ctx)[0]);
    		ArrayList<Reimbursement> ar = es.viewPendingReimb(u);
    		// get list of pending request
    		//set status code
    		// set JSON
    		GsonBuilder gsonBuilder = new GsonBuilder();
    		Gson gson = gsonBuilder.create();
    		String JSONObject = gson.toJson(ar);

    		ctx.result(JSONObject);
    	}
    	else {
    		ctx.result("false");
    	}
    }
    
    public static String[] splitToken(Context ctx) {
    	String token = ctx.header("authToken");    	
    	String[] tokens = token.split(":");
    	return tokens;
    }
}
