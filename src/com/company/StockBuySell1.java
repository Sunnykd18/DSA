package com.company;

public class StockBuySell1 {
    public static void main (String[] args){
        int [] a = {5, 2, 6, 1, 4};
        System.out.println(maxProfit(a));
    }
    static int maxProfit(int [] a ) {

        int maxProfit = 0;
        int min_so_far = a[0];

        int Profit = 0;
        for (int i = 0; i < a.length; i++) {
            min_so_far = Math.min(min_so_far, a[i]);
            Profit = a[i] - min_so_far;
            maxProfit = Math.max(maxProfit, Profit);
        }
        return Profit;
    }

}
