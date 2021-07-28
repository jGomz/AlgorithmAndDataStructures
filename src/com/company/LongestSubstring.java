package com.company;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int longest = 0;

        for(int i =0; i < s.length() ; i++){
            //System.out.println("i "+i);
            set.add(s.charAt(i));
            for(int j =i+1; j < s.length() ; j++){
                boolean add = set.add(s.charAt(j));
                /*System.out.println("j "+j);
                System.out.println("set.size() "+set.size());
                System.out.println("s.length() "+s.length());
                System.out.println(set.toString());*/
                if((!add && set.size()>longest) || (set.size()>longest && j+1 == s.length() && add)){
                    System.out.println("i "+i);
                    System.out.println("j "+j);
                    System.out.println(set.toString());
                    longest=set.size();
                    break;
                }else if(!add){
                    break;
                }
            }
            set.clear();
        }

        return longest;
    }

    public static void main(String[] args) throws IOException {
        LongestSubstring obj = new LongestSubstring();
        String s = "jbpnbwwd";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

}
