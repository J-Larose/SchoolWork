/**
 * COMP1406 - Winter2016 - Assignment 5
 * 
 * This class encapsulates a player in a tic-tac-toe game.
 * See https://en.wikipedia.org/wiki/Tic-tac-toe for more
 * information about tic-tac-toe.
 * 
 * @author <insert your name here>
 * @since <add date of final revision>
 * @custom.citations <add your citations here>
 */

public class TicTacToePlayer{

  /** 
   * Player's name. The name cannot be changed once it is set by the construtor.
   */
  private final String name;  // DO NOT CHANGE THIS

  
  /** Getter for the players name
    * 
    * @return the name of the player
    */
  public String getName(){   // DO NOT CHANGE THIS
    return name; 
  }
     
  
  
  /**
   * Constructor for a tic tac toe player.
   * 
   * @param name is the name of the player.
   * @param p must be either 'x' or 'o'. 
   */
  public TicTacToePlayer(String name, char p){
    //
    // you define this constructor
    //
    this.name = name;
   }
  
  
  /**
   * Checks if a given game instance is over or not.
   * 
   * @param game is an instance of a tic tac toe game (the board)
   * @return true if the game instance is over 
   * (if one player has one or if there is a tie), otherwise false.
   */
  public static boolean gameOver(TicTacToeGame game){
    //
    // your code here
    //
    return true;
  }
  
  /**
   * Checks if a given game instance is over or not.
   * 
   * @param game is an instance of a tic tac toe game (the board)
   * @param p1 is one player in the game
   * @param p2 is the other player in the game
   * @return p1 if player p1 has won the game, p2 if player p2 has 
   * won the game and returns null otherwise (if there is no winner in the given game).
   */
  public static TicTacToePlayer winner(TicTacToeGame game, 
                                       TicTacToePlayer p1,
                                       TicTacToePlayer p2)
  {
    //
    // your code here
    //
    return null;
  }
  
  
  
  /** 
   * Checks if current player is playing x's or o's.
   * 
   * @param none
   * @return true if this object is playing x's and false if the object is playing o's.
   */
  public boolean isX(){
    //
    // your code here
    //
    return true;
  }
  
  /**
   * Getter method that tells if player is playing x's or o's.
   * 
   * @return 'x' if this player is playing x's and returns 'o' if this player is playing o's.
   */
  public char getXO(){
    //
    // your code here
    //
    return 'q';
    }
  
  
  /**
   * Finds a valid move in a tic-tac-toe game for this player
   * 
   * @param game is an instance of a tic-tac-toe game
   * @return A position in the board [0,D-1] that is a valid move for this player to make, 
   * where D = dimention*dimension. 
   * If there are multiple valid moves any is acceptable. 
   * If there are no valid moves then the function returns -1.
   */
  public int findMove(TicTacToeGame game){
    //
    // your code here
    //
    return -5;
  }
  
  /**
   * Finds a valid move in a tic-tac-toe game for this player
   * 
   * @param game is an instance of a tic-tac-toe game
   * @return An array of positions in the board [0,D-1] that are each a valid move 
   * for this player to make, where D = dimension*dimension. 
   * All valid moves must be included in the output. 
   * The order of the positions in the output array do not matter. If there are no
   * valid moves then the function return null. 
   */
  public int[] findAllMoves(TicTacToeGame game){
    //
    // your code here
    //
    return new int[]{-3};
  }
  
  
  
  /**
   * Finds a winning move if possible for this player.
   * 
   * @param game is an instance of a tic-tac-toe game
   * @return A position in the board [0,D-1] that is a valid winning move for this player to make, 
   * where D = dimension*dimension.
   * If there are multiple winning moves then any is acceptable. 
   * Returns -1 if there is no winning move for the player. 
   */
  public int findWinningMove(TicTacToeGame game){
    //
    // your code here
    //
    return -2;
  }
  
  /**
   * Finds a blocking move if possible for this player
   * 
   * 
   * @param game is an instance of a tic-tac-toe game
   * @return A position in the board [0,D-1] that is a valid bocking 
   * move for this player to make, where D = dimension*dimension.
   * If there are multiple blocking moves then any is acceptable.
   * Returns -1 if there is no blocking move for this player.
   */
  public int findBlockingMove(TicTacToeGame game){
    //
    // your code here
    //
    return -3;
  }
  
  
  /** 
   * Plays a move for this player in a game
   * 
   * @param game is a tic-tac-toe game that the player is playing.
   * @param pos is the position [-1,D-1] in the game that the player is playing a move,
   * where D=dimension*dimension.
   * @return Nothing. The function has the side effect of playing a move on the board, 
   * using this player's symbol (x or o) at the specified position. If the position 
   * is -1 then the function does nothing.
   */
  public void play(TicTacToeGame game, int pos){
    //
    // your code here
    //
  }
  
}