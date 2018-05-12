package problems;

import java.util.Scanner;

/**
 * Created by aditya.dalal on 24/02/18.
 */
public class ClosestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.println(getClosestNumber(scanner.nextInt(), scanner.nextInt()));
        }
    }

    private static int getClosestNumber(int dividend, int divisor) {
        if (divisor == 0)
            return 0;
        if (dividend == 0)
            return divisor;
        if (dividend % divisor == 0)
            return dividend;
        double quotient = Math.abs(dividend/(double) divisor);
        int val = (int) quotient;
        double mid = val + 0.5;
        int sign = dividend < 0 ? -1 : 1;
        if (quotient < mid)
            return val * Math.abs(divisor) * sign;
        return ++val * Math.abs(divisor) * sign;
    }
}
