/*
    Implement iterative and recursive binary search.
 */

package main.java;

public class BinarySearch {

    public static void main(String args[]) {
        int arr[] = {2,3,4,10,40};
        int target = 10;
        int result = binarySearchIterative(arr, 0, arr.length -1,target);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);

        result = binarySearchRecursive(arr, 0, arr.length -1,target);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    private static int binarySearchIterative(int arr[], int l, int r, int x) {
        while( l <= r) {
            int mid = l + (r - l)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;
            else if(arr[mid] > x)
                r = mid - 1;
            else if(arr[mid] < x)
                l = mid + 1;
        }
        return -1;
    }

    private static int binarySearchRecursive(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
                return binarySearchRecursive(arr, l, mid-1, x);

            // Else the element can only be present in right
            // subarray
            return binarySearchRecursive(arr, mid+1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }
}
