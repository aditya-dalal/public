package bitwise;

public class DecimalToBinary
{
    public static void main(String[] args)
    {
        int value;

        value = -15;
        System.out.println(Integer.toBinaryString(value));
        decimalToBinaryUsingBitManipulation(value);
        System.out.println();
        decimalToBinaryByDivision(value);
    }

    private static void decimalToBinaryUsingBitManipulation(int value)
    {
        if (value == 0)
            return;
        decimalToBinaryUsingBitManipulation(value >>> 1);
        System.out.print(value & 1);
    }

    private static void decimalToBinaryByDivision(int value)
    {
        int val = value;
        if(val < 0)
        {
            System.out.print(1);
            val = Integer.MAX_VALUE + val + 1;
        }
        if(val == 0)
            return;
        decimalToBinaryByDivision(val/2);
        System.out.print(val%2);
    }

}
