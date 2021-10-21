public static void main(String[] args) {
  
  //An Array variable of type String and name of foodTypes is declared and is assigned the return value of the method getFoodTypes();
	String[] foodTypes = getFoodTypes(); 
  
  //A variable of type String and name of myType is declared and is assigned the value of the 3rd element in foodType array (dinner);
	String myType = foodTypes[2];  

  //An Array variable of type String and name of foodsOfMyType is declared and assigned the return array value of the method getFoodsByType which takes in one String argument.
	String[] foodsOfMyType = getFoodsByType(myType); 
	
  // an enhanced for loop which iterates through each elements in the array foodsOfMyType and references the element value in the food variable.
	for (String food : foodsOfMyType) {
  		//Printing the value of each dinner food (curry, stir fry, burger) using method from java.lang package.
		System.out.println(food);
	}
}

//method named getFoodTypes that does not belong to an instance which returns Array variable of type String.
public static String[] getFoodTypes() {
// An Array variable of type String and name of foodTypes which is assigned the values of different food types.
	String[] foodTypes = {"breakfast","lunch","dinner","dessert","snack"};
	return foodTypes;
}

//method named getFoodsByType that does not belong to an instance which returns Array variable of type String.
// Has one argument that requires a String value to be passed.
// Returns an array of strings when called.
public static String[] getFoodsByType(String type) {

  An Array variable of type String and name of foods is declared with the array size and is assigned null values.
	String[] foods = new String[3];

  
	switch(type) { // declaring switch block with the value to be evulated;
	case "breakfast": // condition that checks if the type is "breakfast" ;
    // Assigns values to each element.
		foods[0] = "pancakes";
		foods[1] = "cereal";
		foods[2] = "omelette";
		break; //terminates the switch block
	case "lunch": // condition that checks if the type is "lunch" ;
  // Assigns values to each element.
		foods[0] = "sandwich";
		foods[1] = "salad";
		foods[2] = "soup";
		break; //terminates the switch block
	case "dinner":  // condition that checks if the type is "dinner" ;
  // Assigns values to each element.
		foods[0] = "curry";
		foods[1] = "stir fry";
		foods[2] = "burger";
		break; //terminates the switch block
	case "dessert": // condition that checks if the type is "dessert" ;
  // Assigns values to each element.
		foods[0] = "cake";
		foods[1] = "ice cream";
		foods[2] = "candy";
		break; //terminates the switch block
	case "snack": // condition that checks if the type is "snack" ;
  // Assigns values to each element.
		foods[0] = "chips";
		foods[1] = "apple";
		foods[2] = "samosa";
		break; //terminates the switch block
	default:  // If no condition above is met, the code below will execute;
		// add your own
		break; //terminates the switch block
	}

	return foods; // returns the array of foods.
}
