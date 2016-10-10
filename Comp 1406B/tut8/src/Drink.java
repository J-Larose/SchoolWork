/**
 * Each drink object has some quantity (amount)
 * and is either salty or not.
 */
public class Drink{
   protected int amount;
   protected boolean salty;
   
   public Drink(int amount, boolean salty){
     this.amount = amount;
     this.salty  = salty;
   }
   
   public int getAmount(){ return this.amount; }
   public boolean isSalty(){ return this.salty; }
       
}