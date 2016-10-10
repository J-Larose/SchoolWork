public class UsePlayer{
   
  public static Food randomFood(){
    boolean healthy= false;
    if( Math.random() < 0.5 ){
      healthy = true;
    }
    return new Food( (int) (Math.random()*10), healthy);      
  }
  
  public static Drink randomDrink(){
    boolean salty= false;
    if( Math.random() < 0.25 ){
      salty = true;
    }
    return new Drink( (int) (Math.random()*10), salty);      
  }

  
  public static void main(String[] args){
    int num = 10;
    
    Bird[] birds = new Bird[num];
    Fish[] fish  = new Fish[num];
    
    for(int i=0; i<num; i+=1){
      birds[i] = new Bird("Bird" + (i+1) );
      fish[i]  = new Fish("Fish" + (i+1) );
    }
    
    // allow everyone to eat and drink something
    for(int i=0; i<num; i++){
      fish[i].eat( randomFood() );
      fish[i].drink( randomDrink() );
      birds[i].eat( randomFood() );
      birds[i].drink( randomDrink() );
      
      System.out.println( fish[i].getName() +  ":" + fish[i].getHealth() );
      System.out.println( birds[i].getName() +":" +  birds[i].getHealth() );
      
      // move to the next day
      fish[i].nextDay();
      birds[i].nextDay();
      
    }
    
    System.out.println(fish[1].toString());
    
    birds[2].health = fish[1].health;
    birds[2].level = fish[1].level;
    birds[2].name = fish[1].name;
    System.out.println( fish[1].getName() +  ":" + fish[1].getHealth() +  ":" + fish[1].getLevel() );
    System.out.println( birds[2].getName() +":" +  birds[2].getHealth()+":" +  birds[2].getLevel() );

    System.out.println(fish[1].equals(birds[2]));
    
    System.out.println(fish[1].hashCode() == fish[2].hashCode());
    
    
  }
}
  