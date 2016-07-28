package problems;

/**
 * Created by aditya.dalal on 04/12/15.
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(fibonacci(5));
    }

    private static long factorial(int num) {
        if(num == 0)
            return 1;
        return num * factorial(num-1);
    }

    private static long fibonacci(int num) {
        if(num < 2)
            return num;
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
