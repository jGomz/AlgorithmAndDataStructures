package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomStack {
    ArrayList<Integer> stack = new ArrayList<>();
    int maxSize;
    int currSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(currSize < maxSize) {
            stack.add(x);
            currSize++;
        }
    }

    public int pop() {
        if(currSize> 0) {
            currSize--;
            return stack.remove(currSize);
        }else
            return -1;
    }

    public void increment(int k, int val){
        int count = 0;
        if(currSize > k)
            count = k;
        else
            count=currSize;

        for(int i=0 ; i<count; i++){
            stack.set(i,stack.get(i)+val);
        }
    }

    public static void main(String[] args) throws IOException {
        CustomStack customStack = new CustomStack(2);
        customStack.push(34);
        System.out.println(customStack.pop());
        customStack.increment(8, 100);
        System.out.println(customStack.pop());
        customStack.increment(9, 91);
        customStack.push(63);
        System.out.println(customStack.pop());
        customStack.push(84);
        customStack.increment(10, 93);
        customStack.increment(6, 45);
        customStack.increment(10, 4);
    }

}
