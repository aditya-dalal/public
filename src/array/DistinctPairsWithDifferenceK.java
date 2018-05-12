package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 19/04/18.
 */
public class DistinctPairsWithDifferenceK {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        pairsWithDifferenceK(arr, 3);
        pairsWithDifferenceK1(arr, 3);
    }

    static void pairsWithDifferenceK(int[] arr, int k) {
        Arrays.sort(arr);
        int l = 0, r = 0, n = arr.length;
        while (r < n) {
            if(arr[r] - arr[l] == k) {
                System.out.println(arr[r] + ", " + arr[l]);
                l++; r++;
            }
            else if (arr[r] - arr[l] > k)
                l++;
            else
                r++;
        }
    }

    static void pairsWithDifferenceK1(int[] arr, int k) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], true);
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i] - k) != null)
                System.out.println(arr[i] + ", " + (arr[i] - k));
            else if(map.get(arr[i]+k) != null)
                System.out.println(arr[i] + ", " + (arr[i] + k));
            if(map.get(arr[i]) != null)
                map.remove(arr[i]);
        }
    }

}
