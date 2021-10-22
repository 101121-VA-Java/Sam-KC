
import java.util.Scanner;

import com.revature.models.Algae;
import com.revature.models.Plant;


public class Driver {
	
	public static void main(String[] args) {
		
		double height = getHeight();
		Algae redAlgae = new Algae("red algae", "red", height, "Unknown", false);
		System.out.println(redAlgae);
		
	}
	
	public static double getHeight() {
		System.out.println("Enter height for plant");
		Scanner sc = new Scanner(System.in);
		try {
			double choice = sc.nextDouble();
			}
			catch(Exception e) {
			 System.out.println("error, invalid data type");
			}
		
		return 0;		
	}
	
}