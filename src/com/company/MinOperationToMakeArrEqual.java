package com.company;

import java.io.IOException;
import java.util.Arrays;

public class MinOperationToMakeArrEqual {
    static public int minOperations(int n) {
        int minOperations = 0;
        int[] arr = new int[n];

        for(int i=0; i<n ; i++){
            arr[i] = (2*i)+1;
        }

        int target = 0;
        for(int i=0; i<arr.length ; i++){
            target += arr[i];
        }

        target = target/n;

        for(int i=0; i<arr.length ; i++){
            if(target!=arr[i]){
                minOperations+=Math.abs(arr[i]-target);
            }
        }

        System.out.println(minOperations);
        System.out.println(Arrays.toString(arr));

        return minOperations/2;
    }

    static int minOperations100(int n) {
        int start=n-1;
        int result=0;
        while(start>0)
        {
            result+=start;
            start-=2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int n = 9;
        System.out.print(minOperations100(n));
    }
}
