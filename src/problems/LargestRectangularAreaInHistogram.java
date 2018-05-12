package problems;

import java.util.Stack;

/**
 * Created by aditya.dalal on 21/02/18.
 */
public class LargestRectangularAreaInHistogram {

    public static void main(String[] args) {
        int[] hist = {6, 2, 5, 4, 5, 2, 5, 1, 6};
        System.out.println(getLargestRectangularArea(hist));
    }

    public static int getLargestRectangularArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int top;
        int areaWithTop;

        int i = 0;
        while (i < hist.length) {
            if(stack.empty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            }
            else {
                top = stack.pop();
                areaWithTop = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (!stack.empty()) {
            top = stack.pop();
            areaWithTop = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }
        return maxArea;
    }
}
