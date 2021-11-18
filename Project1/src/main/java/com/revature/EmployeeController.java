package com.revature;

import io.javalin.http.Context;

public class EmployeeController {
	
    public static void getEmployeeById(Context ctx) {    
    	ctx.result("list");
    }
    
    public static void submitReimbRequest(Context ctx) {    
    	ctx.result("list");
    }
    public static void updateInfo(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewResolvedRequest(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewPendingRequest(Context ctx) {    
    	ctx.result("list");
    }
}
