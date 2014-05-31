package crackingCodingInterview.BitManipulation;

public class FractionalDecimalToBinary
{
    public static void main(String[] args)
    {
        String number = "-3.625";

        System.out.println(decimalToBinary(number));
    }

    public static String decimalToBinary(String value)
    {
        String[] num = value.split("\\.");
        int integer = Integer.parseInt(num[0]);

        String result = intToBinaryByDivision(integer);
//        String result = intToBinaryUsingBitManipulation(integer);    // Using bit manipulation

        double fraction = 0;
        if(num.length > 1)
            fraction = Double.parseDouble("0." + num[1]);

        String fracResult = "";
        if(fraction != 0)
            fracResult = fractionToBinaryWithError(fraction);
//            fracResult = fractionToBinary(fraction);           // Using recursion without checking error condition

        return fracResult.contains("ERROR") ? fracResult : result + "." + fracResult;
    }

    public static String intToBinaryByDivision(int val)
    {
        String result = intToBinary(val);
        if(val < 0)
            return 1+ result;
        return result;
    }

    public static String intToBinary(int val)
    {
        if(val < 0)
            val = Integer.MAX_VALUE + val + 1;
        if(val / 2 == 0)
            return ""+val;
        return intToBinary(val / 2) + (val % 2);
    }

    public static String fractionToBinaryWithError(double value)
    {
        StringBuilder result = new StringBuilder();
        while(value != 1)
        {
            if(result.length() > 32)
                return "ERROR";
            value *= 2;
            if(value == 1)
                result.append(1);
            else if(value > 1)
            {
                result.append(1);
                value -= 1;
            }
            else
                result.append(0);
        }
        return result.toString();
    }

    public static String fractionToBinary(double value)
    {
        double val = value * 2;
        if(val ==  1)
            return "" + 1;
        if(val > 1)
            return 1 + fractionToBinary(val - 1);
        else
            return 0 + fractionToBinary(val);
    }

    public static String intToBinaryUsingBitManipulation(int value)
    {
        if(value == 0)
            return "";
        return intToBinaryUsingBitManipulation(value >>> 1) + (value & 1);
    }


}
