package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;

public class SortMatrixDiagonally {
    static public int[][] diagonalSort(int[][] mat) {
        int[][] ret = new int[mat.length][mat[0].length];
        ArrayList<Integer> sort;

        int row;
        int CountRow =0;
        int col;
        int countSort = 0;
        //Diagonal Inferior
        while(CountRow < mat.length ) {
            row = CountRow;
            col =0;
            sort = new ArrayList<>();
            while (row < mat.length && col < mat[0].length) {
                sort.add(mat[row][col]);
                //System.out.println(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(sort);

            row = CountRow;
            col = 0;
            countSort = 0;
            while (row < mat.length && col < mat[0].length) {
                ret[row][col] = sort.get(countSort);
                row++;
                col++;
                countSort++;
            }
            CountRow++;
        }

        //System.out.println("");
        int CountColumn =1;
        while(CountColumn < mat[0].length ) {
            col = CountColumn;
            row = 0;
            sort = new ArrayList<>();
            while (row < mat.length && col < mat[0].length) {
                sort.add(mat[row][col]);
                //System.out.println(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(sort);
            col = CountColumn;
            row = 0;
            countSort = 0;
            while (row < mat.length && col < mat[0].length) {
                ret[row][col] = sort.get(countSort);
                row++;
                col++;
                countSort++;
            }
            CountColumn++;
        }
        return  ret;
    }


    public static void main(String[] args) throws IOException {
        int[][] arr = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] test =diagonalSort(arr);

        for(int i=0; i<arr.length ; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
    }
}
