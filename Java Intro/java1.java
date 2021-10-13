import javax.swing.JOptionPane;


public class java1 {
   public static void main(String[] args) {

	
      
      int num = Integer.parseInt(JOptionPane.showInputDialog("Number 1 or 2"));
                  
      while ( num != 1 && num!= 2  ) {
             	  
          num = Integer.parseInt(JOptionPane.showInputDialog("Invalid Data"));          
          
      };
      
	JOptionPane.showMessageDialog(null, "You entered " + num);
      
      
   }
}