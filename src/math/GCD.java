package math;

/**
 * Created by aditya.dalal on 17/09/17.
 */
public class GCD {
    public static void main(String[] args)
    {
        int a = 12, b = 400;
        System.out.println("GCD of " + a +" and " + b + " is " + gcdSubtract(a, b));
        System.out.println("GCD of " + a +" and " + b + " is " + gcdDivide(a, b));
    }

    static int gcdSubtract(int a, int b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcdSubtract(a-b, b);
        return gcdSubtract(a, b-a);
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
}
