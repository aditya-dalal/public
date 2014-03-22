package bitwise;

public class CountSetBitsInInteger
{
    public static void main(String[] args)
    {
        int value;

        value = 15;
        System.out.println(getSetBitCountInInteger(value));

        value = -15;
        System.out.println(getSetBitCountInInteger(value));
    }

    private static int getSetBitCountInInteger(int value)
    {
        int count = 0;

        while (value != 0 )
        {
            if((value & 1) == 1)
                count++;
            value >>>= 1;
        }
        return count;
    }
}
