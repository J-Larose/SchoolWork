/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class ChildrensClothing extends Clothing{
    public ChildrensClothing(String name, int cost, int[] date){
        super(name, cost, date);
    }
    
    @Override
    public int sellingPrice(int[] date){
        if (this.date[2]<date[2]){//check year 
            if(date[2]-this.date[2]==1){ //check if within 24 mos
                if (this.date[1]<date[1]){//if current month after manufature month, min 12 mos have pased
                    return Math.round((this.cost*1.10f)*1.05f);
                }else if (this.date[1]==date[1]){//if same month check days
                    if (this.date[0]<date[0]){//if current day after manufature day, been 12 mos
                        return Math.round((this.cost*1.10f)*1.05f);
                    }
                }
            }
            return Math.round((this.cost*1.10f)*1.05f);
        }
        return Math.round((this.cost*1.50f)*1.05f);
    }
}
