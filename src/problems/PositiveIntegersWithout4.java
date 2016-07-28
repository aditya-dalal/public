package problems;

public class PositiveIntegersWithout4
{
    public static void main(String[] args)
    {
        int n = 100000;
        int count = 0;

        for(int i = 1; i < n; i++)
        {
            if(i%2 == 0)
            {
                if(!has4(i))
                    count++;
            }
        }

        System.out.println("Count: " + count);
    }

    private static boolean has4(Integer num)
    {
        if(num.toString().length() > 1)
        {
//            if(num%(10) == 4)
//                return true;
//            return has4(num/10);
            return num%10 == 4 || has4(num/10);
        }
        else if(num == 4)
            return true;
        return false;
    }
}
