package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        char op1 = '{';
        char op2 = '[';
        char op3 = '(';
        char cl1 = '}';
        char cl2 = ']';
        char cl3 = ')';

        Stack<Character> stack = new Stack<>();
        ArrayList<Character> arr = new ArrayList<>();

        for(int i=0; i < s.length()-1; i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.empty())
                    return "NO";

                if(s.charAt(i) == '}' && stack.peek() == '{'){
                    stack.pop();
                }else if(s.charAt(i) == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(s.charAt(i) == ']' && stack.peek() == '['){
                    stack.pop();
                }else{
                    return "NO";
                }
            }
        }

        if(stack.empty())
            return "NO";

        return "YES";
    }



    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        //String nombre =  in.nextLine();
        String nombre =  "jair";
        String esperado = "jair";

        if ( nombre == esperado ) {
            System.out.println("Es jair!!, hola wapote");
        } else {
            System.out.println("Yo solo hablo con jair, srry");
        }
        /*
        String s = "([[)";
        String result = isBalanced(s);

        System.out.println(result);

         */
    }
}