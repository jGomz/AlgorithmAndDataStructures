package com.company;

import java.io.IOException;

public class MedianTwoSortedArray {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid1 = (0 + nums1.length-1) / 2;
        int mid2 = (0 + nums2.length-1) / 2;

        int drop = Math.abs((nums1.length+nums2.length)/2)-1;

        int n1 = 0;
        int n2 = 0;

        int l1 = 0;
        int l2 = 0;

        int mid =0;
        n1 = nums1[returnLeftSide(nums1,0,mid1)];
        n2 = nums2[returnLeftSide(nums2,0,mid2)];
        while(drop > 0){
            if(n1 > n2){
                drop--;
                n2 = nums2[returnLeftSide(nums2,l2+1,mid2-1)];
                mid = n1;
            }else{
                drop--;
                n1 = nums1[returnLeftSide(nums1,l1+1,mid1-1)];
                mid = n2;
            }
        }

        System.out.println(mid);

        return 0;
    }

    static public int binarySearch(int arr[], int x)
    {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    static public int returnLeftSide(int arr[], int l, int r) {
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (l == r)
                return m;
            else
                r = m - 1;
        }
        //someting wrong
        return m;
    }

    static public int returnRightSide(int arr[], int l, int r) {
        int m = r;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (l == r)
                return m;
            else
                l = m + 1;
        }
        //someting wrong
        return m;
    }

    static void printTree(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2)
    {
        int mid1 = (start1 + end1) / 2;
        int mid2 = (start2 + end2) / 2;

        int val = printTree(nums1,  start1, mid1-1);
        System.out.println("val"+val);

        //printTree(nums1, mid1+1, end1, nums2, mid2+1, end2);

    }

    static int printTree(int[] nums1, int start1, int end1)
    {
        int mid1 = (start1 + end1) / 2;
        if (start1 > end1) {
            System.out.println(nums1[mid1]);
            return nums1[mid1];
        }
        printTree(nums1,  start1, mid1-1);
        printTree(nums1, mid1+1, end1);

        return nums1[mid1];
    }

    public static void main(String[] args) throws IOException {
        int[] nums1 = {30,40,50,60,70};
        int[] nums2 = {35,45,55};

        //System.out.println(returnLeftSide(nums1,0,nums1.length-1));
        //System.out.println(returnRightSide(nums1,0,nums1.length-1));

        //printTree(nums2,1, nums2.length-1);
       // printTree(nums1,1, nums1.length-1, nums2, 1, nums2.length-1);
        findMedianSortedArrays(nums1, nums2);

    }
}
