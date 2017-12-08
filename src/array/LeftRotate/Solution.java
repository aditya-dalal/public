package array.LeftRotate;

import java.util.Scanner;

/**
 * Created by aditya.dalal on 17/09/17.
 */
public class Solution {
    static int[] leftRotation(int[] a, int d) {
        int[] temp = new int[a.length];
        int j = 0;
        for(int i = d; i < a.length; i++) {
            temp[j++] = a[i];
        }
        for(int i = 0; i < d; i++) {
            temp[j++] = a[i];
        }
        a = temp;
        return a;

    }


    static void leftRotate(int arr[], int d, int n)
    {
        int i, j, k, temp;
        for (i = 0; i < gcdDivide(d, n); i++)
        {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true)
            {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        for (int a: arr) System.out.print(a + " ");
    }

    static int gcdDivide(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        if (a == b)
            return a;
        if (a > b) {
            int mod = a%b;
            if(mod == 0)
                return b;
            else
                return gcdDivide(mod, b);
        }
        else {
            int mod = b%a;
            if(mod == 0)
                return a;
            else
                return gcdDivide(mod, a);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 6;
        int d = 4;
        int[] a = {1,2,3,4,5,6};
//        for(int a_i = 0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }
        int[] b = new int[n];
        System.arraycopy(a, 0, b, 0, a.length);
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        leftRotate(b, d, b.length);

//        in.close();
    }
}
