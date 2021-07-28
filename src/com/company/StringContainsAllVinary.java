package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StringContainsAllVinary {

    static public boolean hasAllCodes(String s, int k) {
        boolean result = true;
        //Get all the combinations
        int numCom = (int) (Math.pow(2,k)-1);
        System.out.println(numCom);

        /*ArrayList<Integer> combination = new ArrayList<>();
        for(int j=0; j<=numCom; j++){
            combination.add(j);
            System.out.println(combination.get(j));
        }*/

        boolean[] bool = new boolean[numCom+1];
        Arrays.fill(bool,false);

        //ArrayList<String> AllCom = AllCombination(k, combination, 0);
        /*for(int j=0; j<AllCom.size(); j++){
            System.out.println(AllCom.get(j));
        }*/

        int num = 0;
        for(int j=0; j<s.length(); j++){
            if((j+k) > s.length()){
                break;
            }
            //System.out.println(Integer.parseInt(s.substring(j, j+k),2));
            //System.out.println(s.substring(j, j+k));
            num = Integer.parseInt(s.substring(j, j+k),2);

            if(num <= numCom){
                bool[num] = true;
            }
        }

        for(int i=0; i<bool.length; i++){
            if(bool[i]==false){
                return false;
            }
        }

        return true;
    }

    static public ArrayList<String> AllCombination(int n, int arr[], int i){
        ArrayList<String> allCom= new ArrayList<>();
        ArrayList<String> call1;
        ArrayList<String> call2;
        String s="";

        if (i == n)
        {
            for(int j=0; j<arr.length; j++){
                s+=arr[j];
            }
            allCom.add(s);
            return allCom;
        }

        arr[i] = 0;

        call1=AllCombination(n, arr, i + 1) ;
        for(int j=0; j<call1.size();j++){
            allCom.add(call1.get(j));
        }
        arr[i] = 1;
        call2= AllCombination(n, arr, i + 1);
        for(int j=0; j<call2.size();j++){
            allCom.add(call2.get(j));
        }

        return allCom;
    }

    public static void main(String[] args) throws IOException {
       String s = "011101100101110101101000011111101011111101110100111100010000010110010010011100110001110010101101011010010001101111000111110000001010100101111001111010110001111011001110100010001111000111010001111100101011100001001011101100010101010110001011110101001101001001111101000100011101110100100100101101110000000110001011100100111111001000100100010011001000101101100010010010001111010111010011110111110001010100000110000111010110001100100110111000111010111000010100100100101011001111010110010101110101000011011101000110001001100111100011000100110010101100001111000100101001111001100001010100100100110100101100111000110010110101010110010110001111010110101111011011100111001010101001011000101101110100001110011110001011000011100011111001110011111101110001110010000111010011110001011010100101110010110110100011111011110010100011111000000001011100110000010101110110111";
        //String s = "0110";
        int k =7;

        System.out.println(hasAllCodes(s,k));

    }
}
