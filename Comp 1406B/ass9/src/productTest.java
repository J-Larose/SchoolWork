/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class productTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] date1 = {20, 3, 2016};
        int[] date2 = {22, 3, 2016};
        int[] date3 = {20, 7, 2016};
        int[] date4 = {20, 3, 2017};
        
        Clothing c = new Clothing("jacket", 1000, date1);
        ChildrensClothing cc = new ChildrensClothing("lil jacket", 1000, date1);
        Food f = new Food("food", 1000, date1, date3);
        ProcessedFood pf = new ProcessedFood("food", 1000, date1, date3);
        FoodWithExpiration fe = new FoodWithExpiration("food", 1000, date1, date3);

        System.out.println(fe.sellingPrice(date4));
    }
    
}
