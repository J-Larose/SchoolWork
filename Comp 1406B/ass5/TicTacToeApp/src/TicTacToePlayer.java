/**
 * COMP1406 - Winter2016 - Assignment 5
 * 
 * This class encapsulates a player in a tic-tac-toe game.
 * See https://en.wikipedia.org/wiki/Tic-tac-toe for more
 * information about tic-tac-toe.
 * 
 * @author Jacob Larose
 * @since 2016-02-28
 * @custom.citations "I did not use any reference material in developing this assignment."
 */

public class TicTacToePlayer{

  /** 
   * Player's name. The name cannot be changed once it is set by the construtor.
   */
  private final String name;  // DO NOT CHANGE THIS
  /**
   * chosen piece
   * 
   * true == x, false == o
   */
  private boolean piece; // x==true

  
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
    this.name = name;
    switch(p){
        case 'x' :
            this.piece = true;
            break;
        case 'o' :
            this.piece = false;
            break;
        case 'X' :
            this.piece = true;
            break;
        case 'O' :
            this.piece = false;
            break;
    }
  }
  
  
  /**
   * Checks if a given game instance is over or not.
   * 
   * @param game is an instance of a tic tac toe game (the board)
   * @return true if the game instance is over 
   * (if one player has one or if there is a tie), otherwise false.
   */
  public static boolean gameOver(TicTacToeGame game){
    int D = game.getDimension()*game.getDimension();
    boolean full = true;
    for(int i=0; i<D; i++){
        if(game.getAtPosition(i)=='\0'){
            full = false;
        }
    }
    if(full == true){
        return true;
    }


    char check;
    boolean win = false;
    for(int i=0; i<game.getDimension(); i++){
        check = game.getAtPosition(i);
        if(check=='\0'){
            break;
        }
        if(i==0){
           for(int j=0; j<D; j+=game.getDimension()+1){
                if(game.getAtPosition(j)==check){
                    win = true;
                }else{
                    win = false;
                    break;
                }
            } 
           if(win==true){
              return true;
            }
        }
        
        
        for (int j=i; j<D; j+=game.getDimension()){
          if(game.getAtPosition(j)==check){
                win = true;
          }else{
                win = false;
                break;
          }
        }
        if(win==true){
          return true;
        }
    }

    for(int i=0; i<D; i+=game.getDimension()){
        check = game.getAtPosition(i);
        if(check=='\0'){
            break;
        }
        if(i==D-game.getDimension()){
          for(int j=i; j>0; j-=game.getDimension()-1){
              if(game.getAtPosition(j)==check){
                  win = true;
              }else{
                  win = false;
                  break;
              }
          }
          if(win==true){
            return true;
          }
        }



        for (int j=i; j<i+game.getDimension(); j++){
            if(game.getAtPosition(j)==check){
                  win = true;
            }else{
                win = false;
                break;
            }
        }
        if(win==true){
            return true;
        }
    }
 
    return false;
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
      //NOTE: ASSUMING THAT ON AN DxD BOARD D IN A ROW WINS (not explicitly specified in the descriptions)
        int D = game.getDimension()*game.getDimension();
        char check;
        boolean win = false;
        
        
        for(int i=0; i<game.getDimension(); i++){
            check = game.getAtPosition(i);
            if(check!='\0'){
                if(i==0){
                   for(int j=0; j<D; j+=game.getDimension()+1){
                        if(game.getAtPosition(j)==check){
                            win = true;
                        }else{
                            win = false;
                            break;
                        }
                    } 
                   if(win==true){
                      if(p1.getXO()==check){
                          return p1;
                      }else{
                          return p2;
                      }
                    }
                }

                for (int j=i; j<D; j+=game.getDimension()){
                  if(game.getAtPosition(j)==check){
                        win = true;
                  }else{
                        win = false;
                        break;
                  }
                }
                if(win==true){
                  if(p1.getXO()==check){
                      return p1;
                  }else{
                      return p2;
                  }
                }
            }
        }
        
        for(int i=0; i<D; i+=game.getDimension()){
            check = game.getAtPosition(i);
            if(check!='\0'){
                if(i==D-game.getDimension()){
                  for(int j=i; j>0; j-=game.getDimension()-1){
                      if(game.getAtPosition(j)==check){
                          win = true;
                      }else{
                          win = false;
                          break;
                      }
                  }
                  if(win==true){
                    if(p1.getXO()==check){
                        return p1;
                    }else{
                        return p2;
                    }
                  }
                }



                for (int j=i; j<i+game.getDimension(); j++){
                    if(game.getAtPosition(j)==check){
                          win = true;
                    }else{
                        win = false;
                        break;
                    }
                }
                if(win==true){
                    if(p1.getXO()==check){
                        return p1;
                    }else{
                        return p2;
                    }
                }
            }
        }
    return null;
  }
  
  
  
  /** 
   * Checks if current player is playing x's or o's.
   * 
   * @param none
   * @return true if this object is playing x's and false if the object is playing o's.
   */
  public boolean isX(){
    return this.piece;
  }
  
  /**
   * Getter method that tells if player is playing x's or o's.
   * 
   * @return 'x' if this player is playing x's and returns 'o' if this player is playing o's.
   */
  public char getXO(){
      if (this.piece==true){
          return 'x';
      }else{
          return 'o';
      }
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
      int D = game.getDimension()*game.getDimension();
      for(int i=0; i<D; i++){
          if(game.getAtPosition(i)=='\0'){
              return i;
          }
      }
      return -1;
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
      int[] moves = new int[0];
      int D = game.getDimension()*game.getDimension();
      
      for(int i=0; i<D; i++){
          if(game.getAtPosition(i)=='\0'){
            int[] newMoves = new int[moves.length+1];
            System.arraycopy(moves, 0, newMoves, 0, moves.length);
            newMoves[newMoves.length-1] = i;
            moves = newMoves;
          }
      }
      return moves;
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
    //NOTE: ASSUMING THAT ON A DxD BOARD D IN A ROW WINS (not explicitly specified in the descriptions)
    int D = game.getDimension()*game.getDimension();
    char check = this.getXO();
    int count = 0;
    boolean empty = true;
    int emptySpace = 0;
    

    for(int i=0; i<game.getDimension(); i++){
        if(i==0){
            for(int j=0; j<D; j+=game.getDimension()+1){
                if(game.getAtPosition(j)==check){
                    count += 1;
                }else if(game.getAtPosition(j)!='\0'){
                    empty = false;
                    break;
                }else{
                    empty = true;
                    emptySpace = j;
                }
            } 
            if(empty==true && count==game.getDimension()-1){
                return emptySpace;
            }
        }
        count = 0;
        for (int j=i; j<D; j+=game.getDimension()){
            if(game.getAtPosition(j)==check){
                count += 1;
            }else if(game.getAtPosition(j)!='\0'){
                empty = false;
                break;
            }else{
                empty = true;
                emptySpace = j;
            }
        }
        if(empty==true && count==game.getDimension()-1){
            return emptySpace;
        }
        count = 0;
    }

    for(int i=0; i<D; i+=game.getDimension()){
        if(i==D-game.getDimension()){
            for(int j=i; j>0; j-=game.getDimension()-1){
                if(game.getAtPosition(j)==check){
                    count += 1;
                }else if(game.getAtPosition(j)!='\0'){
                    empty = false;
                    break;
                }else{
                    empty = true;
                    emptySpace = j;
                }
            }
            if(empty==true && count==game.getDimension()-1){
                return emptySpace;
            }
        }
        count = 0;


        for (int j=i; j<i+game.getDimension(); j++){
            if(game.getAtPosition(j)==check){
                count += 1;
            }else if(game.getAtPosition(j)!='\0'){
                empty = false;
                break;
            }else{
                empty = true;
                emptySpace = j;
            }
        }
        if(empty==true && count==game.getDimension()-1){
            return emptySpace;
        }
        count = 0;
    }
    return -1;
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
    //NOTE: ASSUMING THAT ON A DxD BOARD D IN A ROW WINS (not explicitly specified in the descriptions)
    int D = game.getDimension()*game.getDimension();
    char check = this.getXO();
    if (check=='x'){
        check = 'o';
    }else if(check=='o'){
        check = 'x';
    }
    int count = 0;
    boolean empty = true;
    int emptySpace = 0;
    

    for(int i=0; i<game.getDimension(); i++){
        if(i==0){
            for(int j=0; j<D; j+=game.getDimension()+1){
                if(game.getAtPosition(j)==check){
                    count += 1;
                }else if(game.getAtPosition(j)!='\0'){
                    empty = false;
                    break;
                }else{
                    empty = true;
                    emptySpace = j;
                }
            } 
            if(empty==true && count==game.getDimension()-1){
                return emptySpace;
            }
        }
        count = 0;
        for (int j=i; j<D; j+=game.getDimension()){
            if(game.getAtPosition(j)==check){
                count += 1;
            }else if(game.getAtPosition(j)!='\0'){
                empty = false;
                break;
            }else{
                empty = true;
                emptySpace = j;
            }
        }
        if(empty==true && count==game.getDimension()-1){
            return emptySpace;
        }
        count = 0;
    }

    for(int i=0; i<D; i+=game.getDimension()){
        
        if(i==D-game.getDimension()){
            for(int j=i; j>0; j-=game.getDimension()-1){
                if(game.getAtPosition(j)==check){
                    count += 1;
                }else if(game.getAtPosition(j)!='\0'){
                    empty = false;
                    break;
                }else{
                    empty = true;
                    emptySpace = j;
                }
            }
            if(empty==true && count==game.getDimension()-1){
                return emptySpace;
            }
        }
        count = 0;



        for (int j=i; j<i+game.getDimension(); j++){
            if(game.getAtPosition(j)==check){
                count += 1;
            }else if(game.getAtPosition(j)!='\0'){
                empty = false;
                break;
            }else{
                empty = true;
                emptySpace = j;
            }
        }
        if(empty==true && count==game.getDimension()-1){
            return emptySpace;
        }
        count = 0;
    }
    return -1;
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
      if (pos == -1){
      }else if(game.getAtPosition(pos)!= '\0'){
          System.out.println("there is a piece there");
      }else{
          game.play(pos, this);
      }
      
  }
  
}