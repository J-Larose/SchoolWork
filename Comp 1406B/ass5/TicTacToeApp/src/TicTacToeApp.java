/**
 * COMP1406 - Winter2016 - Assignment 5
 * 
 * This is a Java program that allows a use to play a game
 * against the computer (TicTacToePlayer)
 * 
 * @author Jacob Larose
 * @since 2016-02-28
 * @custom.citations "I did not use any reference material in developing this assignment."
 */

import java.util.Scanner;  // used for input

public class TicTacToeApp{
  
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    

    
    String input = "";
    String name;
    char choice;
    int pos = 0;
    int x;
    int turnCount;
    System.out.println("What is your name?  ");
    name = keyboard.next();
    
    while(!input.equals("quit")){
        turnCount = 1;
        TicTacToeGame board = new TicTacToeGame();
        System.out.println(board.show());
        
        
        System.out.println("What piece would you like?  ");
        choice = keyboard.next().charAt(0);
        
        
        TicTacToePlayer user = new TicTacToePlayer(name, choice);

        if(choice == 'x' || choice == 'X'){
            choice = 'o';
        }else{
            choice = 'x';
        }

        TicTacToePlayer computer = new TicTacToePlayer("computer", choice);


        while(true){
            if(turnCount > 8){
                System.out.println("Tie!!");
                System.out.println("Would you like to play again? 'quit' for no, 'yes' for yes");
                input = keyboard.next();
                break;
            }
            if(user.getXO()=='x'){
                System.out.println("Where would you like to play");
                try{
                    input = keyboard.next();
                    pos = Integer.parseInt(input);
                }catch (java.lang.NumberFormatException e){
                    if("quit".equals(input)){
                        break;
                    }
                }
                user.play(board, pos);
                turnCount += 1;
            }else{
                if (computer.findWinningMove(board)!=-1){
                    x = computer.findWinningMove(board);
                    computer.play(board, x);
                    System.out.println("Computer plays "+ x);
                }else if(computer.findBlockingMove(board)!=-1){
                    x = computer.findBlockingMove(board);
                    computer.play(board, x);
                    System.out.println("Computer plays "+ x);

                }else{
                    x = computer.findMove(board);
                    computer.play(board, x);
                    System.out.println("Computer plays "+ x);
                }
                System.out.println(board.show());
                turnCount += 1;

            }

            if(TicTacToePlayer.winner(board, user, computer)!=null){
                System.out.println(board.show());
                System.out.println(TicTacToePlayer.winner(board, user, computer).getName() + " wins!!");
                System.out.println("Would you like to play again? 'quit' for no, 'yes' for yes");
                input = keyboard.next();
                break;
            }

            if(user.getXO()=='o'){
                System.out.println("Where would you like to play");
                try{
                    input = keyboard.next();
                    pos = Integer.parseInt(input);
                }catch (java.lang.NumberFormatException e){
                    if("quit".equals(input)){
                        break;
                    }
                }
                user.play(board, pos);
                turnCount += 1;
            }else{
                if (computer.findWinningMove(board)!=-1){
                    x = computer.findWinningMove(board);
                    computer.play(board, x);
                    System.out.println("Computer plays "+ x);
                }else if(computer.findBlockingMove(board)!=-1){
                    x = computer.findBlockingMove(board);
                    computer.play(board, x);
                    System.out.println("Computer plays "+ x);

                }else{
                    x = computer.findMove(board);
                    computer.play(board, x);
                    System.out.println("Computer plays "+ x);
                }
                System.out.println(board.show());
                turnCount += 1;
            }
            
            if(TicTacToePlayer.winner(board, user, computer)!=null){
                System.out.println(board.show());
                System.out.println(TicTacToePlayer.winner(board, user, computer).getName() + " wins!!");
                System.out.println("Would you like to play again? 'quit' for no, 'yes' for yes");
                input = keyboard.next();
                break;
            }
        }
    }
  }
}