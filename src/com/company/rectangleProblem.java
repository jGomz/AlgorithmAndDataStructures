package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class rectangleProblem {
        public int[][] rectangle;

    public rectangleProblem(int[][] rectangle) {
            this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int row = row1;
        int col = col1;

        while(row<=row2){
            col = col1;
            while(col<=col2){
                rectangle[row][col] = newValue;
                col++;
            }
            row++;
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) throws IOException {
        int[][] rectangle = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};

        rectangleProblem obj = new rectangleProblem(rectangle);
        for (int i = 0; i < obj.rectangle.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < obj.rectangle[i].length; j++) { //this equals to the column in each row.
                System.out.print(obj.rectangle[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        System.out.println();
        System.out.println(obj.getValue(0, 2));
        System.out.println();

        obj.updateSubrectangle(0, 0, 3, 2, 5);

        for (int i = 0; i < obj.rectangle.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < obj.rectangle[i].length; j++) { //this equals to the column in each row.
                System.out.print(obj.rectangle[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        System.out.println();


    }
}
