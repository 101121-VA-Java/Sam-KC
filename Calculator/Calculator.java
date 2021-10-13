public class Calculator {
   public static void main(String[] args) {

   	System.out.println("Adding: 9 + 10 | " + add(9,10));
   	System.out.println("Subtracting: 11 - 10 | " + subtract(11,10));
   	System.out.println("Multiplying: 10 * 10 | " + multiply(10,10));
   	System.out.println("Remainder: 10 % 2 | " + multiply(10,2));
   	System.out.println("Day: Wednesday | " + weekday("Wednesday"));
   	System.out.println("Countdown 10");
   	countdown(10);
   	System.out.println("Greeting: Sam");
   	greeting("Sam");
   }


	 static int add(int a, int b)
	 {
	    return a + b;
	 }
	 static int subtract(int a, int b)
	 {
	    return a - b;
	 }
	 static double multiply(double a, double b)

	 {
	    return a * b;
	 }
	 static  int remainder(int a, int b)

	 {
	    return a % b;
	 }	 

	 static String weekday(String weekday)

	 {

	 String returnStatement;	 
	    switch(weekday) {
		case "Monday":
		returnStatement = "its Monday";
	    break;
	    case "Tuesday":
		returnStatement = "its Tuesday";
	    break;
	    case "Wednesday":
		returnStatement = "its Wednesday";
	    break;
	    case "Thursday":
		returnStatement = "its Thursday";
	    break;
	    case "Friday":
		returnStatement = "its Friday";
	    break;
	    default:
    	returnStatement = "Not a Weekday";
    	break;    	
    	}
    	return returnStatement;
	 }	 

	 public static void countdown(int startValue) {

	 	int n;
	 for(n=startValue; n>=0; n--) { 
	      System.out.println(n);
	    }

	 }

	 static void greeting(String name)
	 {
	 System.out.println("Hello, " + name);
	 }

 }