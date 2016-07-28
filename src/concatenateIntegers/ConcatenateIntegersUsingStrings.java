package concatenateIntegers;

public class ConcatenateIntegersUsingStrings
{
    public static void main (String[] args)
    {
        int a = 1234;
        int b = 567890123;

        String firstString = String.valueOf(a);
        String secondString = String.valueOf(b);
        String result = firstString + secondString;
        result = result.length() > 10 ? result.substring(0,10) : result;
        int c = Integer.parseInt(result);
        System.out.println(c);
    }
}
