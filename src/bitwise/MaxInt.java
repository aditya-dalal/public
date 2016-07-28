package bitwise;

public class MaxInt
{
    public static void main(String[] args)
    {
        System.out.println(Integer.MAX_VALUE);
        int val = 1;
        int result = val << 31;  // results to -2147483647(decimal) = 10000000 00000000 00000000 00000000
        System.out.println(~result);  // inverts 0 and 1. (011111111 111111111 111111111 111111111)

        val = 0;
        result = ~val;    // results to -1(decimal) =  111111111 111111111 111111111 111111111
        System.out.println(result >>> 1);     // unsigned right shift. results to 011111111 111111111 111111111 111111111

        val = -1;
        System.out.println(result >>> 1);   // Same as above
    }
}
