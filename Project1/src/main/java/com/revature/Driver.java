package com.revature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	private static Logger log = LogManager.getRootLogger();
	public static void main(String[] args) {
	Routes route = new Routes();
	route.run();
	log.info("Server Started");
	}
	
}
