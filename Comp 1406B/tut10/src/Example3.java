import java.util.Scanner;

public class Example3{
  
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    String input;
    int num, den;
    
    try{
      System.out.print("Enter the numerator: ");
      input = keyboard.next();
      num = Integer.parseInt(input);
      
      System.out.print("Enter the deminator: ");
      input = keyboard.next();
      den = Integer.parseInt(input);
      
      if( den == 0){
        throw new Exception("you tried to divide by zero!");
      }
      
      System.out.println( "" + num + "/" + den + " = " + num/den );
    }
    catch(Exception e){
      System.out.println(e);   
    }
  }
  
  
}