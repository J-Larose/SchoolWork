public abstract class Player{
   protected String name;
   protected int    health;
   protected int    level;
   
   public Player(String name){
     this.name = name;
     this.level = 1;
   }
   
   public String getName(){ return name; }
   public int    getHealth(){ return health; }
   public int    getLevel(){ return level; }
   
   public abstract void eat(Food food);
   public abstract void drink(Drink drink);

   public void nextDay(){
     this.health -= 2;
   }
   
   @Override
   public String toString(){
       String str = this.getClass() + " named : " + this.getName();
       return str;
   }
   
   public boolean equals(Player p){
        return this.getClass()==p.getClass() && this.getHealth()==p.getHealth()
                &&this.getLevel()==p.getLevel()  && this.getName().equals(p.getName());
    }
   
   @Override
   public int hashCode(){
       int hash = 1;
       hash = hash + this.getClass().hashCode();
       hash = hash * 17 + this.getLevel();
       hash = hash * 31 + this.getHealth();
       return hash;
   }
   
}