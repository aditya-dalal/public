package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 05/04/17.
 */
public class PositionOfZeroBinaryStringMaxOnes {

    public static void main(String[] args) {
        String str = "00111000110101000111110100011011";
        System.out.println(getPositionOfZeroBruteForce(str));
        System.out.println(getPositionOfZeroSlidingWindow(str, 2));
    }

    public static List<Integer> getPositionOfZeroSlidingWindow(String str, int maxFlips) {
        int left = 0, right = 0, zeros = 0, window = 0, lpos = 0, rpos = 0;
        while (right < str.length()) {
            if(zeros <= maxFlips) {
                if(str.charAt(right++) == '0')
                    zeros++;
            }
            if(zeros > maxFlips) {
                if (str.charAt(left++) == '0')
                    zeros--;
            }
            if(right - left > window) {
                window = right-left;
                lpos = left;
                rpos = right-1;
            }
        }
        List<Integer> positions = new ArrayList<>();
        while (lpos <= rpos) {
            if (str.charAt(lpos) == '0')
                positions.add(lpos);
            lpos++;
        }
        return positions;
    }

    public static int getPositionOfZeroBruteForce(String str) {
        if(str.length() == 0)
            return -1;
        if (str.length() == 1 && str.charAt(0) == '0')
            return 0;
        int max = 0, pos = -1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0' ) {
                int count = 0;
                if(i-1 >= 0 && str.charAt(i-1) == '1') {
                    int j = i - 1;
                    while (j >= 0 && str.charAt(j--) == '1')
                        count++;
                }
                if(i+1 < str.length() && str.charAt(i+1) == '1') {
                    int j = i + 1;
                    while (j < str.length() && str.charAt(j++) == '1')
                        count++;
                }
                if(max < count) {
                    max = count;
                    pos = i;
                }
            }
        }
        return pos;
    }
}
