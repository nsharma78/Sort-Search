/*'
 * Find a peak element
 * Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors. For corner elements, we need to consider only one neighbor.
 * For example, for input array {5, 10, 20, 15}, 20 is the only peak element. For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90.
 * Note that we need to return any one peak element.
 */
package main.java;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 2, 23, 90, 67};
        System.out.println("The peak elelment in the array is: " + findPeak(arr));
    }

    private static int findPeak(int[] arr) {
        int l = 0, r = arr.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;
            if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == arr.length -1 ||  arr[mid+1] <= arr[mid]))
                return arr[mid];
            else if(arr[mid] < arr[mid -1]) {
                r = mid - 1;
            }
            else if(arr[mid] > arr[mid -1]) {
                l = mid + 1;
            }
        }
        return -1;
    }

}
