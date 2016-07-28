package concatenateIntegers;

public class ConcatenateIntegers
{
    public static void main (String[] args)
    {
        int a = 1234;
        int b = 567890123;

        int lengthA = intLength(a);
        int lengthB = intLength(b);
        int totalLength = lengthA + lengthB;
        int remainingDigits = 10-lengthA;

        if(totalLength > 10)
        {
            int temp = a * (int) Math.pow(10, remainingDigits);
            System.out.println(temp + b/(int) Math.pow(10, lengthB-(remainingDigits)));
        }
        else
        {
            System.out.println(a * (int) Math.pow(10, lengthB) + b);
        }

    }

    private static int intLength(int value)
    {
        int[] arr = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        int length = 1;

        for(int temp : arr)
        {
            if(value > temp)
                length += 1;
            else
                break;
        }
        return length;
    }
}
