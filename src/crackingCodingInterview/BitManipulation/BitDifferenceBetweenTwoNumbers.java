package crackingCodingInterview.BitManipulation;

public class BitDifferenceBetweenTwoNumbers
{
    public static void main(String[] args)
    {
        int num1 = Integer.parseInt("111000",2);
        int num2 = Integer.parseInt("111",2);

        System.out.println(bitsRequiredToConvertNumbers(num1, num2));
    }

    public static int bitsRequiredToConvertNumbers(int num1, int num2)
    {
        int val = num1 ^ num2;
        int count = 0;
        while(val != 0)
        {
            if((val & 1) == 1)
                count++;
            val >>>= 1;
        }
        return count;
    }

}