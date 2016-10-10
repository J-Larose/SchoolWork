import java.util.Scanner;

public class Adventure{    
  Room start = null;
  
  public void initialize(int num){
    // create a game instance with num rooms
    start = AdventureInit.init(num);    
  }
  
  public void play(){
    // play the game
    Scanner keyboard = new Scanner(System.in);
    System.out.print("what is your name? ");
    String s = keyboard.nextLine();
    Player p = new Player(s, 0, 100, "My name is " + s);
    
    Room room = start;
    
    //
    // you need to implement the game
    //
    
    System.out.println( room.getDescription() );
    
    while( p.getHealth() > 0 ){
      
      System.out.print( "What do you want to do? ");
      s = keyboard.nextLine().trim().toLowerCase();
      
        switch (s) {
            case "get food":
                {
                    int f = room.getFood();
                    if( f <= 0 ){
                        System.out.println("There is no food.");
                    }else{
                        System.out.println("Yum.  That was good. Heath increased by " + f);
                        p.eatFood(f);
                    }           break;
                }
            case "get treasure":
                {
                    int f = room.getTreasure();
                    if( f <= 0 ){
                        System.out.println("There is no treasure.");
                    }else{
                        System.out.println("yay.  You're now " + f + "richer");
                        p.getRicher(f);
                    }           break;
                }
            case "go north":
                if( room.exit[0] != null){
                    room = room.exit[0];
                    System.out.println("Ok, let's go north.");
                }else{
                    System.out.println("Really? There is no exit north from here.");
                }       break;
            case "go south":
                if( room.exit[1] != null){
                    room = room.exit[1];
                    System.out.println("Ok, let's go south.");
                }else{
                    System.out.println("Really? There is no exit south from here.");
                }       break;
            case "go east":
                if( room.exit[2] != null){
                    room = room.exit[2];
                    System.out.println("Ok, let's go east.");
                }else{
                    System.out.println("Really? There is no exit east from here.");
                }       break;
            case "go west":
                if( room.exit[3] != null){
                    room = room.exit[3];
                    System.out.println("Ok, let's go west.");
                }else{
                    System.out.println("Really? There is no exit west from here.");
                }       break;
            case "go hidden":
                if( room.exit[0] != null){
                    room = room.exit[0];
                    System.out.println("Ok, let's go hidden.");
                }else{
                    System.out.println("Really? There is no exit hidden from here.");
                }       break;
            case "where am i":
                System.out.println( room.getDescription() );
                break;
            default:
                System.out.println( "you cant do that." );
                break;
        }
    }
    
    
    
    
    
    
  }
  
  
  
  public static void main(String[] args){
    Adventure game = new Adventure();
    
    game.initialize(10);    
    game.play();
    
    
  }
  
  
  
}   