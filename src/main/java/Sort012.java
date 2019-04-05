/*
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
Examples:
Input :  {0, 1, 2, 0, 1, 2}
Output : {0, 0, 1, 1, 2, 2}
Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */

package main.java;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println("Original Array: " + Arrays.toString(arr));
        sort012(arr);
        System.out.println("Original Array: " + Arrays.toString(arr));
    }

    private static void sort012(int[] arr) {
        int start  = 0, mid = 0, end = arr.length - 1;
        int pivot = 1;

        while(mid <= end) {
            if(arr[mid] < pivot) {
                swap(arr, start, mid);
                ++start;
                ++mid;
            }
            else if(arr[mid] > pivot) {
                swap(arr, mid, end);
                --end;
            }
            else
                ++mid;
        }

    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}