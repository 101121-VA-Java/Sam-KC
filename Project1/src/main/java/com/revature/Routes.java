package com.revature;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import io.javalin.Javalin;

public class Routes {
	
	public void run() {
	
	Javalin app = Javalin.create( (config) -> {		
	}).start();
	
		
	app.routes(() -> {
		
		path("login", ()->{			
				post(UserAuthController::loginUser);
		});
		path("employee", ()->{
			path("submitReimbRequest",() ->{
				post(EmployeeController::submitReimbRequest);
			});
			path("{id}",() ->{
				get(EmployeeController::getEmployeeById);
			});
		});
				
	});
	
	}
		
}
