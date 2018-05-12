package array;

/**
 * Created by aditya.dalal on 19/03/18.
 */
public class FindSubarrayWithMaximumSum {
    public static void main(String[] args) {
        int [] arr = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
        subArraysWithMaximumSum(arr);
    }

    public static void subArraysWithMaximumSum(int[] arr) {
        int max = arr[0], sum = arr[0], start = 0, end = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > sum+arr[i]) {
                if(arr[i] > sum) {
                    start = i;
                    end = i;
                }
                sum = arr[i];
            }
            else {
                sum += arr[i];
            }
            if(max < sum) {
                max = sum;
                end = i;
            }
        }
        System.out.println("Max sum: " + max);
        System.out.println("subarray: " + start + ", " + end);
    }
}
