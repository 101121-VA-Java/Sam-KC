public class ControlFlow{

    public static void main(String[] args){

        System.out.println(echo("test", 2));
      
        } 



            /*
     This method should return the sum of all of the element of an array of integer.
     */
    public static int sum(int[] intArr){

        // logic
        int i ;
        int sum = 0;
        for (i = 0; i < intArr.length; i++) {
        sum += intArr[i];
        }

        return sum;
    }

    /*
     This method should return a string composed of the word multiplied by the number of time and separated by a space.
     */
    public static String echo(String word, int times){

        // logic
        String returnString = "" ;

        returnString += returnString + " " ;

        return returnString;
    }

    }




