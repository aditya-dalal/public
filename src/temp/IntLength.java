package temp;

public class IntLength
{
    public static void main(String[] args)
    {
        int a = 10000;
        System.out.println(intLength(a));
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
