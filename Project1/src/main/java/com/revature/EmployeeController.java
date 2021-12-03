package com.revature;

import java.util.ArrayList;


import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;
import com.revature.services.EmployeeService;
import com.revature.services.UserAuth;

import io.javalin.http.Context;

public class EmployeeController {
	
    public static void getEmployeeById(Context ctx) {    
    	

    }
    
    public static void submitReimbRequest(Context ctx) {    
    	

    	if (UserAuthController.checkToken(ctx) == true) { 
    	EmployeeService es = new EmployeeService();
    	User u = es.viewAccountInfo(splitToken(ctx)[0]);    	
    	System.out.println(u.getFirstName());
    	//double amount, String submittedDate, String description, User author, int status,
		//int type
    	Reimbursement r =ctx.bodyAsClass(Reimbursement.class);
    	r.setAuthor(u);
    	ReimbursementStatus rs = new ReimbursementStatus(1);
    	r.setStatus(rs);
    	es.submitReimbRequest(r);
    	ctx.status(200);
    	;
    	}
    	else {
    		ctx.status(400);
    		
    	}
    	
    }
    public static void updateInfo(Context ctx) {    
    	if (UserAuthController.checkToken(ctx) == true) {     		
    		User u = ctx.bodyAsClass(User.class);
    		UserAuth ua = new UserAuth();
    		
    		if (ua.updateUserInfo(u)) {
    			ctx.status(200);
    			}
    		else {
    			ctx.status(500);
    			}    		    		
    	}
    	else {
    		ctx.status(400);
    	}
    }
    
    public static void viewInfo(Context ctx) {    
    	if (UserAuthController.checkToken(ctx) == true) { 
    	EmployeeService es = new EmployeeService();
    	User u = es.viewAccountInfo(splitToken(ctx)[0]);
		ctx.json(u);
    	}
    	else {
    		ctx.status(400);
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
  
    		
    		ctx.json(ar);
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

    		System.out.println(ar.toString());
    		ctx.json(ar);
    		
    	}
    	else {
    		ctx.status(400);
    		ctx.result("false");
    	}
    }
    
    public static String[] splitToken(Context ctx) {
    	String token = ctx.header("authToken");    	
    	String[] tokens = token.split(":");
    	return tokens;
    }
    
    public static void fetchChanges(Context ctx) {
    	
    }
}
