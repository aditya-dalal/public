package array.ArrayQueries;

import java.util.Scanner;

/**
 * Created by aditya.dalal on 02/10/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        for(int i = 0; i < m; i++) {
            int type = scanner.nextInt();
            int start = scanner.nextInt()-1;
            int end = scanner.nextInt()-1;
            long[] tarr = new long[end-start+1];

            if(type == 1) {
                if(start == 0)
                    continue;
                int j = start, k = 0;
                while (j <= end)
                    tarr[k++] = arr[j++];
                int prev = start-1;
                while(prev >= 0)
                    arr[end--] = arr[prev--];
                for(k = 0; k < tarr.length; k++)
                    arr[k] = tarr[k];
            }
            else if(type == 2) {
                if(end == n-1)
                    continue;
                int j = start, k = 0;
                while (j <= end)
                    tarr[k++] = arr[j++];
                int next = end+1;
                while (next <= n-1)
                    arr[start++] = arr[next++];
                for (k = 0; k < tarr.length; k++)
                    arr[start++] = tarr[k];
            }
        }
        System.out.println(Math.abs(arr[0] - arr[n-1]));
        for(long i: arr)
            System.out.print(i + " ");
    }
}
