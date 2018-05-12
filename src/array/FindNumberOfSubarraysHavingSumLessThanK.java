package array;

/**
 * Created by aditya.dalal on 19/03/18.
 */
public class FindNumberOfSubarraysHavingSumLessThanK {
    public static void main(String[] args) {
        int [] arr = new int[] {2,4,1,6,3,2};
        int k = 10;
        System.out.println(subArraysWithSumLessThanK(arr, k));
    }

    public static int subArraysWithSumLessThanK(int[] arr, int k) {
        int i = 0, j = 0, sum = 0, count = 0;
        while (j < arr.length) {
            if(sum + arr[j] < k) {
                sum += arr[j];
                count += 1 + j - i;
                j++;
            }
            else
                sum -= arr[i++];
        }
        return count;
    }
}
