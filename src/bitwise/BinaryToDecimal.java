package bitwise;

public class BinaryToDecimal
{
    public static void main(String[] args)
    {
        String binaryStr = "101011";

        System.out.println(Integer.parseInt(binaryStr, 2));

        System.out.println(binaryToDecimal1(binaryStr));
        System.out.println(binaryToDecimal2(binaryStr));
        System.out.println(anyBaseToDecimal(binaryStr, 2));

        String octalStr = "350";
        System.out.println(anyBaseToDecimal(octalStr, 8));
        System.out.println(Integer.parseInt(octalStr, 8));
    }

    private static int binaryToDecimal1(String binaryStr)
    {
        int value = 0;
        String temp = new StringBuffer(binaryStr).reverse().toString();

        for(int i = 0; i < binaryStr.length(); i++)
        {
            value += (temp.charAt(i) == '1' ? 1 : 0) * Math.pow(2, i);
        }
        return value;
    }

    private static int binaryToDecimal2(String binaryStr)
    {
        int value = 0;
        int length = binaryStr.length();

        for(int i = 0; i < length; i++)
        {
            if(binaryStr.charAt(i) == '1')
                value += Math.pow(2, length-i-1);
        }
        return value;
    }

    private static int anyBaseToDecimal(String str, int base)
    {
        int value = 0;

        for(int i = 0; i < str.length(); i++)
        {
            value = value * base + Character.getNumericValue(str.charAt(i));
        }
        return value;
    }
}
