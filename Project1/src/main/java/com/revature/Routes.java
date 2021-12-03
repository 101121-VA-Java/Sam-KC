package com.revature;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;
import io.javalin.Javalin;

public class Routes {
	
	public void run() {
	
	Javalin app = Javalin.create( (config) -> {		
		config.enableCorsForAllOrigins();
	}).start(80);
	
	
	app.routes(() -> {
		
		path("auth", ()->{			
				post(UserAuthController::loginUser); //An Employee/Manager can login ---
		});
		path("account", ()->{				
				get(EmployeeController::viewInfo); //An Employee can view their information
				put(EmployeeController::updateInfo);  //An Employee can update their information
			
	});
		
		path("reimbursement", ()->{	 			
			post(EmployeeController::submitReimbRequest); //An Employee can submit a reimbursement request	
			put(ManagerController::changeReimbStatus); //A Manager can approve/deny pending reimbursement requests
			
			path("pending",() ->{ 
				path("all",() ->{
				get(ManagerController::getAllPendingReimbursement); //A Manager can view all pending requests from all employees
				});
				path("{username}",() ->{ //An employee can view their pending requests
					get(EmployeeController::viewPendingRequest);
				});
			});
			path("resolved",() ->{ 
				//Manager can view all resolved requests from all employees and see which manager resolved it
				path("all",() ->{
					get(ManagerController::getAllResolvedReimbursement);
				});
				path("{username}",() ->{ 
					get(EmployeeController::viewResolvedRequest); //An employee can view their resolved request
				});
				
			});
			path("{username}",() ->{  
				get(ManagerController::viewReimbByUsername); //Manager can view reimbursement requests from a single Employee 
			});
		});
		path("employees", ()->{
			path("",() ->{
				get(ManagerController::viewAllEmployees); //Manager can view all employees
			});
		});

				
	});
	
	}
		
}
