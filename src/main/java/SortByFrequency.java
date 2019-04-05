/*
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
Examples:
Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */

package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};

        System.out.println("Original Array: " + Arrays.toString(arr));
        sortFrequent(arr);
        System.out.println("Original Array: " + Arrays.toString(arr));
    }

    private static Map<Integer, Elem> map = new HashMap<>();

    static class Elem implements Comparable<Elem> {
        int num;
        int index;
        int count;

        public Elem(int num, int index, int count) {
            this.num = num;
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(Elem o) {
            if(this.count == o.count)
                return this.index - o.index;
            else
                return o.count - this.count;
        }
    }

    private static void sortFrequent(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                Elem elem = map.get(arr[i]);
                elem.count++;
                map.put(arr[i], elem);
            }
            else {
                map.put(arr[i], new Elem(arr[i], i, 1));
            }
        }
        List<Elem> list = new ArrayList<Elem>(map.values());

        Collections.sort(list);
        int i = 0;
        for(Elem elem : list) {
            while(elem.count-- != 0)
                arr[i++] = elem.num;
        }

    }

}