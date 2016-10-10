public class Bird extends Player{
    
    
     public Bird(String name){
        super(name);
        this.health = 25;
        
    }
    
    @Override
    public void eat(Food food){
        if (food.isHealthy()){
            this.health += 2;
        }else{
            this.health -= 3;
        }
        this.levelUp();
    }
    
    @Override
    public void drink(Drink drink){
        if(drink.isSalty()){
            this.health -= 1;
        }else{
            this.health += 2;
        }
        this.levelUp();
    }
    
    private void levelUp(){
        if (this.health>=50){
            this.level++;
            this.health = 25;
        }else if(this.health<=0){
            this.level--;
            this.health = 25;
        }
        
        if(this.level<=0 && this.health<=0){
            System.out.println("this fish is dead");
        }
    } 
}