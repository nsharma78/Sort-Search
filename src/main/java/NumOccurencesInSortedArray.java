/*
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)
  Examples:
  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
  Output: 4 // x (or 2) occurs 4 times in arr[]
  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
  Output: 1
  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
  Output: 2
  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
  Output: 0 // 4 doesn't occur in arr[]
 */

package main.java;

public class NumOccurencesInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int n = 2;
        System.out.println("The number " + n + " occurs " + numOccur(arr, arr.length - 1, n) + " times.");

    }

    private static int numOccur(int[] arr, int n, int target) {
        int ind = binarySearch(arr, 0, n, target);

        // If element is not present
        if (ind == -1)
            return 0;

        // Count elements on left side.
        int count = 1;
        int left = ind - 1;
        while (left >= 0 && arr[left] == target)
        {
            count++;
            left--;
        }

        // Count elements
        // on right side.
        int right = ind + 1;
        while (right < n && arr[right] == target)
        {
            count++;
            right++;
        }

        return count;
    }

    static int binarySearch(int arr[], int l, int r, int x) {

        if (r < l)
            return -1;

        int mid = l + (r - l) / 2;

        // If the element is present
        // at the middle itself
        if (arr[mid] == x)
            return mid;

        // If element is smaller than
        // mid, then it can only be
        // present in left subarray
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);

        // Else the element can
        // only be present in
        // right subarray
        return binarySearch(arr, mid + 1, r, x);
    }
}
