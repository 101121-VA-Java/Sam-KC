package com.revature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.ManagerService;
import com.revature.services.UserAuth;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;


public class ManagerController {
	
	
	
    public static void getAllPendingReimbursement(Context ctx) {   
    	ManagerService ms = new ManagerService();
    	if (UserAuthController.checkToken(ctx) == true) {     		
  		    ctx.json(ms.viewPendingRequests());
    	}
    	else {
    		ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }
    public static void getAllResolvedReimbursement(Context ctx) { 
    	ManagerService ms = new ManagerService();
    	if (UserAuthController.checkToken(ctx) == true) {     		
    		ctx.json(ms.viewResolvedRequests());
    	}
    	else {
    		ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }
    public static void viewAllEmployees(Context ctx) {
    	ManagerService ms = new ManagerService();
    	if (UserAuthController.checkToken(ctx) == true) {     		
    		ctx.json(ms.viewAllEmployees());
    	}
    	else {
    		ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }
    public static void viewReimbByUsername(Context ctx) {    
    	String username1 = ctx.pathParam("username");  
		System.out.println(username1);
    	if (UserAuthController.checkToken(ctx) == true) {  
    		String username = ctx.pathParam("username");  
    		System.out.println(username);
    		ManagerService ms = new ManagerService();   
    		
    		if (ms.viewRequestByUsername(username) != null){
    		ctx.json(ms.viewRequestByUsername(username));
    		}
    		else {
    		ctx.status(400);
    		}
	    		
    	}
    	else {
    		ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }
    public static void changeReimbStatus(Context ctx) {    
    	
    	int reimbId = 0;
    	int statusId = 0;
   	
    	System.out.println(ctx.body());
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			JsonNode actualObj = mapper.readTree(ctx.body());
			reimbId = Integer.valueOf(actualObj.path("reimbId").asText());
			statusId = Integer.valueOf(actualObj.path("statusId").asText());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			ctx.status(400);
		}
    	
    	if (UserAuthController.checkToken(ctx) == true) {  
    		
    		try {
    		ManagerService ms = new ManagerService();
    		UserAuth ua = new UserAuth();
        	String userName = ctx.header("authToken").split(":")[0];  
        	int resolverID = ua.getUserbyUsername(userName).getUserId();  
        			//int reimbId, int statusId, int resolverID
    			if (ms.updateRequestStatus(reimbId, statusId, resolverID)) {
    				ctx.status(200);
    			}
    			else {
    				ctx.status(400);
    			}
    			}
    			catch(Exception e) {
    				System.out.println(e);
    				ctx.status(300);
    			}
    		
	    		
    	}
    	else {
    		ctx.status(HttpCode.UNAUTHORIZED);
    	}
    }

}
