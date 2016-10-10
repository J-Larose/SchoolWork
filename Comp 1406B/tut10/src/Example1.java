public class Example1{
  
  public int quotient(int numerator, int denominator){
    return numerator / denominator;
  }
  
  public static void nothing(){
    nothing();
  }
  
  
 
   public static void main(String[] args){
   Example1 example = new Example1();
   //nothing();
   System.out.println( example.quotient(3,0) );
   
   }
   
}