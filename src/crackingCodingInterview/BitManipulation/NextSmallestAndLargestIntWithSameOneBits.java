package crackingCodingInterview.BitManipulation;

public class NextSmallestAndLargestIntWithSameOneBits
{
    public static void main(String[] args)
    {
        int num = Integer.parseInt("111111000", 2);
        System.out.println(Integer.toBinaryString(num));
        int nextLarge = getNextLargeNumberWithSameBits(num);
        System.out.println(nextLarge);
        System.out.println(Integer.toBinaryString(nextLarge));
        System.out.println(Integer.toBinaryString(largeWithBruteForce(num)));

        System.out.println();
        int nextSmall = getNextSmallNumberWithSameBits(num);
        System.out.println(nextSmall);
        System.out.println(Integer.toBinaryString(nextSmall));
        System.out.println(Integer.toBinaryString(smallWithBruteForce(num)));
    }

    public static int getNextLargeNumberWithSameBits(int value)
    {
        int oneMask = 1;
        int pos = 0;
        while((value & oneMask) == 0)
        {
            oneMask <<= 1;
            pos++;
        }
        int oneCount = 0;
        while((value & oneMask) != 0)
        {
            oneCount++;
            oneMask <<= 1;
            pos++;
        }
        int val = value | oneMask;
        int mask = -1 << pos;
        val &= mask;

        mask = 0;
        for(int i = 0; i < oneCount - 1; i++)
        {
            mask <<= 1;
            mask |= 1;
        }
        return val | mask;
    }

    public static int getNextSmallNumberWithSameBits(int num)
    {
        int oneMask = 1;
        int pos = 0, oneCount = 0;
        int val = num;
        while(pos <= 32 && (val & oneMask) != 0)
        {
            val ^= oneMask;
            oneMask <<= 1;
            pos++; oneCount++;
        }
        while(pos <= 32 && (val & oneMask) == 0)
        {
            oneMask <<= 1;
            pos++;
        }
        oneCount++;
        val ^= oneMask;
        int mask = 0;
        for(int i = 0; i < oneCount; i++)
        {
            mask <<= 1;
            mask |= 1;
        }
        System.out.println(Integer.toBinaryString(mask));
        mask <<= pos - oneCount;
        return val | mask;
    }

    public static int largeWithBruteForce(int num)
    {
        int oneCount = getOneCount(num);
        num++;
        while(oneCount != getOneCount(num))
            num++;
        return num;
    }

    public static int smallWithBruteForce(int num)
    {
        int oneCount = getOneCount(num);
        num--;
        while(oneCount != getOneCount(num))
            num--;
        return num;
    }


    public static int getOneCount(int value)
    {
        int count = 0;
        while(value != 0)
        {
            if((value & 1) == 1)
                count++;
            value >>>= 1;
        }
        return count;
    }

}