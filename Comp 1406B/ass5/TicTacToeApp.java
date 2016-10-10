/**
 * COMP1406 - Winter2016 - Assignment 5
 * 
 * This is a Java program that allows a use to play a game
 * against the computer (TicTacToePlayer)
 * 
 * @author <insert your name here>
 * @since <add date of final revision>
 * @custom.citations <add your citations here>
 */

import java.util.Scanner;  // used for input

public class TicTacToeApp{
  
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);  
    
    String input = "";
    while( !input.equals("quit") ){
      input = keyboard.next();
      System.out.println(input);
    }
    
    //
    
    
    
    
  }
}