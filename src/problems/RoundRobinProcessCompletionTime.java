package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 28/02/18.
 */
public class RoundRobinProcessCompletionTime {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1,2,5}; // index 2
//        2,1,3,0,1,4
//        1,0,2,0,3
//        0,1,2
//        0
        System.out.println(getCompletionTime(arr, 2));
    }

    public static int getCompletionTime(int[] arr, int index) {
        int n = arr.length;
        int m = arr[index];
        int maxTime = (m-1) * n + index + 1;
        System.out.println(maxTime);
        List<Integer> loops = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i < index && arr[i] < m) {
                loops.add(m - arr[i]);
            }
            if(i > index && arr[i] < m) {
                loops.add(m - arr[i] - 1);
            }
        }
        for (int val: loops)
            maxTime -= val;
        return maxTime;
    }
}
