package array;

/**
 * Created by aditya.dalal on 13/10/17.
 */
public class MinimumPositiveIntNotPresent {
    public static void main(String[] args) {
        int[] arr = {3,-1,0,5,2,1,-45,100};
        int i = 0;
        while (i < arr.length) {
            int val = arr[0];
            if (val >= 1 && val < arr.length) {
                int temp = arr[val];
                arr[val] = -1;
                if (temp >= 1 && temp < arr.length)
                    arr[0] = temp;
                else if (++i < arr.length)
                    arr[0] = arr[i];
            } else if (++i < arr.length)
                arr[0] = arr[i];
        }
        int res = 0;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                res = i;
                break;
            }
        }
        System.out.println(res == 0 ? i : res);
    }
}
