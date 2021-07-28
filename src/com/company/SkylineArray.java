package com.company;

import java.io.IOException;
import java.util.Arrays;

public class SkylineArray {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topBot = new int[grid.length];
        int[] rightLeft = new int[grid[0].length];
        int maxTB = 0;
        int maxRL = 0;

        for (int i = 0; i < grid.length; i++) { //this equals to the row in our matrix.
            maxRL = 0;
            maxTB = 0;
            for (int j = 0; j < grid[i].length; j++) { //this equals to the column in each row.
                if(grid[i][j]>maxRL){
                    maxRL = grid[i][j];
                    rightLeft[i] = maxRL;
                }

                if(grid[j][i]>maxTB){
                    maxTB = grid[j][i];
                    topBot[i] = maxTB;
                }
            }
        }

        System.out.println(Arrays.toString(rightLeft));
        System.out.println(Arrays.toString(topBot));

        int min = 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < grid[i].length; j++) { //this equals to the column in each row.
                if(topBot[i] < rightLeft[j]){
                    min = topBot[i];
                }else{
                    min = rightLeft[j];
                }

                if(grid[j][i]<min) {
                    sum += (min - grid[j][i]);
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        int[][] rectangle = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};

        rectangleProblem obj = new rectangleProblem(rectangle);

        for (int i = 0; i < obj.rectangle.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < obj.rectangle[i].length; j++) { //this equals to the column in each row.
                System.out.print(obj.rectangle[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        System.out.print(maxIncreaseKeepingSkyline(rectangle));

    }
}
