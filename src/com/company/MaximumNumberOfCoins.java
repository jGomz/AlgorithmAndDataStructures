package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class MaximumNumberOfCoins {
    static public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length/3;
        int sum = 0;
        int index = piles.length-2;
        while(n>0){
            sum += piles[index];
            n--;
            index-=2;
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(piles));
    }

}
