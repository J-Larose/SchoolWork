/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class FoodWithExpiration extends Food{
    public FoodWithExpiration(String name, int cost, int[] date, int[] expirationDate){
        super(name, cost, date, expirationDate);
    }
        
    @Override
    public int sellingPrice(int[] date){
        if (this.bestBeforeDate[2]==date[2]){//if same year check more
            if (this.bestBeforeDate[1]==date[1]){//if same month check days
                if (this.bestBeforeDate[0]==date[0]){//if same day, 1/2 price
                    return Math.round(this.cost/2);
                }else if(this.bestBeforeDate[0]==date[0]-1){//if day before 1/2 price
                    return Math.round(this.cost/2);
                }else if (this.bestBeforeDate[0]<date[0]){//if current day after expiration day, expired
                    return -1;
                }else{ //if (this.bestBeforeDate[0]>date[0]) //if current day before expiration day, not expired
                    return this.cost*2;
                }
            }else if (this.bestBeforeDate[1]<date[1]){//if current month after expiration month, expired
                return -1;
            }else{// if (this.bestBeforeDate[1]>date[1]) if current month before expiration month, not expired
                return this.cost*2;
            }
        }else if (this.bestBeforeDate[2]<date[2]){//if current year after expiration year expired
            return -1;
        }else{//if current year before expiration year not expired
            return this.cost*2;
        }
    }
}
