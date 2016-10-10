public class Player{    
  
  protected String name; 
  protected String message;
  protected int treasure = 0;
  protected int health = 100;
  
  public Player(String name, int treasure, int health, String message){
    this.name = name;
    this.treasure = treasure;
    this.health = health;
    this.message = message;
   }
 
  public String ask(){
    return message;
  }
  
  public void eatFood(int f){
    health += f;
  }
  
  public void getRicher(int f){
      this.treasure += f;
  }
  
  public int getHealth(){ return health; }
  public int getTreasure(){ return treasure; }
  
}   