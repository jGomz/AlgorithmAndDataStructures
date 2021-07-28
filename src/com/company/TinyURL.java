package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class TinyURL {
    static ArrayList<String> arr = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    static public String encode(String longUrl) {
        arr.add(longUrl);
        return idToShortURL(arr.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    static public String decode(String shortUrl) {
        return arr.get(shortURLtoID(shortUrl));
    }

    static String idToShortURL(int n){
        char[] baseChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuffer shortURL  = new StringBuffer();  ;

        while(n > 0){
            shortURL.append(baseChar[n%62]);
            n = n/62;
        }
        return shortURL.reverse().toString();
    }

    static int shortURLtoID(String shortURL){
        int id =0;
        for(int i=0 ; i<shortURL.length() ; i++){
            if('a' <= shortURL.charAt(i) && shortURL.charAt(i) <='z')
                id = id*62 + shortURL.charAt(i) - 'a';
            if('A' <= shortURL.charAt(i) && shortURL.charAt(i) <='Z')
                id = id*62 + shortURL.charAt(i) - 'A'+ 26;
            if('0' <= shortURL.charAt(i) && shortURL.charAt(i) <='9')
                id = id*62 + shortURL.charAt(i) - '0' +52;
        }
        return id;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(encode("www.google.com"));
        //System.out.println(decode(encode("www.google.com")));
    }
}
