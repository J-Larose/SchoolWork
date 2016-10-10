public class Fish extends Player{
    
    public Fish(String name){
        super(name);
        this.health = 50;
        
    }
    
    @Override
    public void eat(Food food){
        if (food.isHealthy()){
            this.health += food.getAmount()/4;
        }else{
            this.health -= food.getAmount()/5;
        }
        this.levelUp();
    }
    
    @Override
    public void drink(Drink drink){
        this.health += drink.getAmount()/10;
        this.levelUp();
    }
    
    protected void levelUp(){
        if (this.health>=100){
            this.level++;
            this.health = 50;
        }else if(this.health<=0){
            this.level--;
            this.health = 40;
        }
        
        if(this.level<=0 && this.health<=0){
            System.out.println("this fish is dead");
        }
    }
    
    
    public class FreshWaterFish extends Fish{
        public FreshWaterFish(String name){
            super(name);
        }
        
        @Override
        public void drink(Drink drink){
            if(drink.isSalty()){
                this.health -= 5;
            }else{
                this.health += drink.getAmount()/10;
            }
            this.levelUp();
        }
    }
    
}
