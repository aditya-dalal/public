package array;

/**
 * Created by aditya.dalal on 19/03/18.
 */
public class FindMaximumSumInSubarray {
    public static void main(String[] args) {
        int [] arr = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(subArraysWithMaximumSum(arr));
    }

    public static int subArraysWithMaximumSum(int[] arr) {
        int max = arr[0], sum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
