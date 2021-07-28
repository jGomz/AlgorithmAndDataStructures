package com.company;

import java.io.IOException;
import java.util.Arrays;

public class QueriesOnAPermutationWithKey {

    static public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m];
        int[] ret = new int[m-1];

        for(int i=0; i<p.length; i++){
            p[i]=i+1;
        }

        for(int i=0; i<queries.length; i++){
            System.out.println(Arrays.toString(p));
            ret[i] = search(p, queries[i]);
            System.out.println(ret[i]);

            for(int j = ret[i]; j > 0; j--) {
                p[j] = p[j-1];
            }
            p[0]=queries[i];
        }

        return ret;
    }

    static public int search(int arr[], int x)
    {
        for(int i=0; i<arr.length; i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        int[] arr = {3,1,2,1};
        int m = 5;

        System.out.println(Arrays.toString(processQueries(arr,m)));
    }
}
