package concatenateIntegers;

public class ConcatenateIntegers
{
    public static void main (String[] args)
    {
        int a = 1234;
        int b = 567890123;

        int lengthA = String.valueOf(a).length();
        int lengthB = String.valueOf(b).length();
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
}
