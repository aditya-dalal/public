package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aditya.dalal on 19/03/18.
 */
public class FindSubArrayWithGivenSum {
    public static void main(String[] args) {

        int [] arr = new int[] {-10, 10, 2, -2, -20, 10}; // -10, 0, 2, 0, -20, -10
        subArraysWithSum(arr, -10);
    }

    public static void subArraysWithSum(int arr[], int val){
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == val)
                System.out.println(0 + " " + i);
            int temp = sum-val;
            if(map.containsKey(temp)) {
                for(int index : map.get(temp))
                    System.out.println((index + 1) + " " + i);
            }
            if(map.containsKey(sum))
                map.get(sum).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            }
        }

    }
}
