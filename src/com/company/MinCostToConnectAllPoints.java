package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class MinCostToConnectAllPoints {

    static public int distManhathan(int[] x, int[] y){
        return Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
    }

    static public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        int res = 0;
        int[][] pairwiseDist = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                pairwiseDist[i][j] = distManhathan(points[i], points[j]);
                //System.out.println("i: "+i+" j: "+j+" Dist "+pairwiseDist[i][j]);
            }
        }

        int[] distToTree = new int[N];
        Arrays.fill(distToTree, Integer.MAX_VALUE);

        HashSet<Integer> inTree = new HashSet<>();
        int newNode = 0;

        while (inTree.size() + 1 != N) {
            inTree.add(newNode);
            int minDist = Integer.MAX_VALUE, minID = 0;
            for (int i = 0; i < N; ++i) {
                if (inTree.contains(i))
                    continue;

                distToTree[i] = Math.min(distToTree[i], pairwiseDist[newNode][i]);
                System.out.println("i: "+i+" distToTree "+distToTree[i]);

                if (distToTree[i] < minDist) {
                    minDist = distToTree[i];
                    minID = i;
                    System.out.println(Arrays.toString(distToTree));
                    System.out.println("minID: "+i+" minDist "+distToTree[i]);
                    System.out.println(pairwiseDist[newNode][i]);
                }
            }
            System.out.println("");
            res += minDist;
            newNode = minID;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int[][] arr = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        minCostConnectPoints(arr);
    }

}
