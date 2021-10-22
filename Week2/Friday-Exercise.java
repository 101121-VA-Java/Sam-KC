public class Food {

	//A variable of type String and name of name is declared with no value assigned to it.
	public String name;
	//A variable of type String and name of type is declared with no value assigned to it.
	public String type;


	//Constructor for the class Food which takes two String arguments. 
	public Food(String name, String type) {

		// Sets the name and type with the input value when this object is created.
		this.name = name;
		this.type = type;
	}

	// Method named cook with has no return value or arguments.
	public void cook() {
		// condition that checks if name does NOT contain "cooked".
		if (!name.contains("cooked")) {
		// 	Re-assigns the value of name with "cooked " before the name.
			name = "cooked " + name;
		}
	}
}


public class Main {
	// Defines the entry point for the program to run.
	public static void main(String[] args) {
		//A variable of type Food and name of myFood is declared.
		// A new object is created invoking the constructor by giving the value "potato", and "vegetable".
		// The object is assigned to myFood.
		Food myFood = new Food("potato", "vegetable");

		// The cook() method is executed which changes the name to "cooked potato".
		myFood.cook();
		//Prints the value of food "cooked potato" using method from java.lang package.
		System.out.println(myFood.name);
	}
}
