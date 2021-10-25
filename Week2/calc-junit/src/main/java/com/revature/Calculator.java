package com.revature;

import com.revature.exceptions.CalculatorException;

public class Calculator extends CalculatorException {

	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	
	public double add(double x, double y) {
		return x + y;
	}
	
	public double subtract(double x, double y) {
		return x - y;
	}
	
	public double multiply(double x, double y) {
		return x * y;
	}
	
	public double divide(double x, double y) {
		if (y == 0) {
			throwAE();
			}
		return x/y;
	}
	
	public boolean isPrime(int i) {		
		if (i == 1 ) { return false;}
	    for(int ii=2;ii<i;ii++) {
	        if(i%ii==0)
	            return false;
	    }
	    return true;
	}
}