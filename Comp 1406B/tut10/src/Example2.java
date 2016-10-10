import java.util.Scanner;

public class Example2{
  
  // create a bigger array and copy contents over to it
  public static String[] resize(String[] array){
    String[] newArray = new String[ array.length + 3 ];
    for(int i=0; i<array.length; i+=1){
      newArray[i] = array[i];
    }
    return newArray;
  }
  
  
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    String input = "";
    
    String[] inputs = new String[3]; // holds input strings
    int size = 0;                    // how many are stored
    while(  !input.toLowerCase().equals("quit") ){
      System.out.println("What do  you want to do?");
      System.out.println("  type a to add data\n  type d to display data");
      System.out.print("your choice : ");
      input = keyboard.next();
      if( input.toLowerCase().equals("d") ){
        System.out.print("Which element? (enter an integer) : ");
        try{
            input = keyboard.next();
            if (Integer.parseInt(input)>size){
                throw new ArrayIndexOutOfBoundsException();
            }
            System.out.println( inputs[ Integer.parseInt(input) ] );
        }catch(NumberFormatException e){
            System.out.println("must be int");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("must be in array");
        }
      }else if( input.toLowerCase().equals("a") ){
          try{
                System.out.print("What do you want to add? ");
                input = keyboard.next();
                if(inputs.length<size){
                    throw new ArrayIndexOutOfBoundsException();
                }
                inputs[size] = input;
                size++;
          }catch(ArrayIndexOutOfBoundsException e){
              inputs = resize(inputs);
              inputs[size] = input;
              size++;
          }
        
      }else{
        System.out.println("Please try again");
      }
    }
  
  }
}