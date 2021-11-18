package com.revature;
import io.javalin.http.Context;


public class ManagerController {
	
    public static void getAllPendingReimbursement(Context ctx) {    
    	ctx.result("list");
    }
    public static void getAllResolvedReimbursement(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewAllEmployees(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewReimbByUserId(Context ctx) {    
    	ctx.result("list");
    }
    public static void changeReimbStatus(Context ctx) {    
    	ctx.result("list");
    }

}
