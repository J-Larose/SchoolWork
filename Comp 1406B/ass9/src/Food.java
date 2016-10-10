/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class Food extends Product{
    protected int[] bestBeforeDate = new int[3];
    public Food(String name, int cost, int[] date, int[] expirationDate){
        super(name, cost, date);
        this.bestBeforeDate = expirationDate;
    }
    
    @Override
    public int sellingPrice(int[] date){
        if (this.bestBeforeDate[2]==date[2]){//if same year check more
            if (this.bestBeforeDate[1]==date[1]){//if same month check days
                if (this.bestBeforeDate[0]==date[0]){//if same day, not expired
                    return this.cost*2;
                }else if (this.bestBeforeDate[0]<date[0]){//if current day after expiration day, expired
                    return this.cost;
                }else{ //if (this.bestBeforeDate[0]>date[0]) //if current day before expiration day, not expired
                    return this.cost*2;
                }
            }else if (this.bestBeforeDate[1]<date[1]){//if current month after expiration month, expired
                return this.cost;
            }else{// if (this.bestBeforeDate[1]>date[1]) if current month before expiration month, not expired
                return this.cost*2;
            }
        }else if (this.bestBeforeDate[2]<date[2]){//if current year after expiration year expired
            return this.cost;
        }else{//if current year before expiration year not expired
            return this.cost*2;
        }
    }
}
