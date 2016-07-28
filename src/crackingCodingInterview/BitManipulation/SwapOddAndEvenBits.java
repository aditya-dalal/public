package crackingCodingInterview.BitManipulation;

public class SwapOddAndEvenBits
{
	public static void main(String[] args)
	{
		int val = 100000;

        System.out.println(Integer.toBinaryString(val));
        System.out.println(Integer.toBinaryString(swapOddAndEvenBitsBruteForce(val)));
        System.out.println(Integer.toBinaryString(swapOddAndEvenBits(val)));
    }

	public static int swapOddAndEvenBitsBruteForce(int val)
	{
		int odd = 2;
		int even = 1;
		int zeroMask = 1;
		int oneMask = -2;

		for(int i = 0; i < 16; i++)
		{
            int oddBit = val & odd;
			int evenBit = val & even;
            if(oddBit > 0)
				val |= zeroMask;
			else
				val &= oneMask;
			zeroMask <<= 1;
			oneMask <<= 1;
			oneMask++;
			if(evenBit > 0)
				val |= zeroMask;
			else
				val &= oneMask;
			zeroMask <<= 1;
			oneMask <<= 1;
			oneMask++;
            odd <<= 2;
            even <<= 2;
		}
		return val;
	}

    public static int swapOddAndEvenBits(int val)
    {
        int odd = (val & 0xaaaaaaaa) >> 1;
        int even = (val & 0x55555555) << 1;
        return odd | even;
//        return ( ((val & 0xaaaaaaaa) >> 1) | ((val & 0x55555555) << 1) );
    }
}