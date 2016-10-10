/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package larose_101013798_q2;

import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Jacob
 */
public class Larose_101013798_Q2 {

    public int factorial(int n) {
        if (n != 0){
            int x = 1;
            int y = n+1;
            for(int i=1; i < y; i++){
                x = x*i;
            }
            return x;
        }else{
            return 1;
        }
    }
    public ArrayList combination(int n, ArrayList row, Larose_101013798_Q2 instance) {
        int k = 0;
        while(k<=n){
            int x = instance.factorial(n);
            int y = instance.factorial(k);
            int z = (instance.factorial((n-k)));
            int a = (x/(y*z));
            row.add(a);

            k += 1;
        }
        
        return row;
    }
    public static void main(String[] args) {
        Larose_101013798_Q2 instance = new Larose_101013798_Q2();
        ArrayList row = new ArrayList();
        Scanner in = new Scanner(System.in);
        int n = 0;
        System.out.print("Enter the number to look for: ");
        int num = in.nextInt();
        
        while(!row.contains(num)){
            row.clear();
            row = instance.combination(n, row, instance);
            System.out.print(row);
            System.out.println();
            n++;
        }
    }
    
}
