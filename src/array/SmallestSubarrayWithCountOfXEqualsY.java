package array;

import java.io.IOException;

/**
 * Created by aditya.dalal on 08/04/18.
 */
public class SmallestSubarrayWithCountOfXEqualsY {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[] arr = {1,1,1,4,2,1,4,3,1,5,6,7,8,4,9,0,1,1};
        subArray(arr, 10, 4);
    }

    static void subArray(int[] arr, int x, int y) {
        int xcount = 0, ycount = 0;
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] == x)
                xcount++;
            else if(arr[i] == y)
                ycount++;
        }

        int count = Math.min(xcount, ycount);
        int l =0 , r=0;
        xcount = 0;
        ycount = 0;
        while (r < arr.length){
            if(arr[r] == x) {
                xcount++;
                if(xcount > count) {
                    while (xcount != count) {
                        if(arr[l] == x)
                            xcount--;
                        else if(arr[l] == y)
                            ycount--;
                        l++;
                    }
                }
            }
            if (arr[r] == y) {
                ycount++;
                if(ycount > count) {
                    while (ycount != count) {
                        if(arr[l] == x)
                            xcount--;
                        else if(arr[l] == y)
                            ycount--;
                        l++;
                    }
                }
            }
            if(xcount == count && ycount == count) {
                System.out.println(l + ": " + r);
                break;
            }
            r++;
        }
    }
}
