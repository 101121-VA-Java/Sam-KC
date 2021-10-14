public class ArrayPractice {




   public static void main(String[] args) {

   	String[] stringList = {"One", "Two", "Three"};   	

   	String ar[] = reverseArray(stringList);
  

   	int i ;
   	for (i = 0; i < ar.length; i++) {
   		System.out.println(ar[i]);
   	}

   }


   static String[] reverseArray(String[] stringList)

	 {	 
	 String returnArray[];
	 returnArray = new String[stringList.length];	 
	 int n;
	 int index = 0;

	 for(n=stringList.length - 1; n>=0; n--) { 	
	    returnArray[index] = stringList[n];
	    index ++; 
	    };
	  return returnArray;

	 }


}