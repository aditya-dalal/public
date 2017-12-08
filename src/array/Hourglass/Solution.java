package array.Hourglass;

import java.util.Scanner;

/**
 * Created by aditya.dalal on 16/09/17.
 */
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//        int[][] input = new int[6][6];
//        for(int i = 0; i < 6; i++) {
//            String[] in = scanner.nextLine().split(" ");
//            for(int j = 0; j < in.length; j++) {
//                input[i][j] = Integer.parseInt(in[j]);
//            }
//        }
        int[][] input = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };
        System.out.println(maxSum(input));
    }

    private static int maxSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int sum = getSum(arr, i, j);
                if (max < sum)
                    max = sum;
            }
        }
        return max;
    }

    private static int getSum(int[][] arr, int x, int y) {
        int total = 0;
        for(int i = y; i < y+3; i++) {
            total += arr[x][i];
            total += arr[x+2][i];
        }
        total += arr[x+1][y+1];
        return total;
    }
}
