/**
 * Each food object has some quantity (amount)
 * and is either healthy or not.
 */
public class Food{
   protected int amount;
   protected boolean healthy;
   
   public Food(int amount, boolean healthy){
     this.amount = amount;
     this.healthy  = healthy;
   }
   
   public int getAmount(){ return this.amount; }
   public boolean isHealthy(){ return this.healthy; }
       
}