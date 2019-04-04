package main.java;

public class LinearSearch {

    public static void main(String[] args) {
        int arr[] = {2,3,4,10,40,75,99};
        System.out.println("The array contains 4: " + linearSearch(arr, 4));
        System.out.println("The array contains 8: " + linearSearch(arr, 8));
        System.out.println("The array contains 40: " + linearSearch(arr, 40));
        System.out.println("The array contains 76: " + linearSearch(arr, 76));
        System.out.println("The array contains 99: " + linearSearch(arr, 99));
    }

    private static boolean linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
                return true;
        }
        return false;
    }

}
