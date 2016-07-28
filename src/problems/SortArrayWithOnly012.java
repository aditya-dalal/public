package problems;

import java.util.Arrays;

/**
 * Created by aditya.dalal on 30/11/15.
 */
public class SortArrayWithOnly012 {

    public static void main (String[] args) {
        Integer[] arr = {1,1,2,1,0,1,2,1,2,0,2,1,1,2,0};
//        Arrays.sort(arr);
        dutchNationalFlagAlgorithm(arr);
    }

    public static void sort(Integer[] arr) {
        int[] count = new int[3];
        for(int i: arr)
            count[i] += 1;

        int index = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < count[i]; j++)
                arr[index++] = i;
        }

        for(int i : arr)
            System.out.print(i + ",");
        System.out.println();
    }

    public static void dutchNationalFlagAlgorithm(Integer[] arr) {
        int lo = 0, mid = 0, hi = arr.length-1, temp;
        while(mid <= hi) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = temp;
                    hi--;
                    break;
                }
            }
        }
        for (int i : arr)
            System.out.print(i + ",");
        System.out.println();
    }
}
