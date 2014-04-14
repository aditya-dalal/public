package bitwise;

public class DecimalToAnyBase
{
    public static void main(String[] args)
    {
        char[] hex = "0123456789abcdef".toCharArray();

        int number = 15;

        System.out.println(decimalToAnyBase(number, hex.length, hex, ""));
    }

    private static String decimalToAnyBase(int decimalNumber, int base, char[] baseDigits, String baseNumber)
    {
        if(decimalNumber/base != 0)
            return decimalToAnyBase(decimalNumber / base, base, baseDigits, baseNumber) + baseDigits[decimalNumber%base];
        return baseNumber + baseDigits[decimalNumber%base];
    }
}
