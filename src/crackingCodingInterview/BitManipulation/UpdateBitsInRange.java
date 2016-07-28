package crackingCodingInterview.BitManipulation;

public class UpdateBitsInRange
{
	public static void main(String[] args)
	{
		int n = Integer.parseInt("10000000000", 2);
		int m = Integer.parseInt("10101", 2);
		int i = 2;
		int j = 6;

		int result = updateBits(n, m, i, j);
		System.out.println(Integer.toBinaryString(result));
        int result1 = updateBits1(n, m, i, j);
        System.out.println(Integer.toBinaryString(result1));
    }

	public static int updateBits(int n, int m, int i, int j)
	{
		int mask = ~0;
		mask = mask << j+1;
        int temp = ~0 << i;
        temp = ~temp;
		mask |= temp;
        n &= mask;
        m <<= i;
        return n | m;
//        return (n & mask) | (m << i);    // Last three lines can be replaced by this line
	}

    public static int updateBits1(int n, int m, int i, int j)
    {
        int max = ~0;
        int left = max - ((1 << j+1) - 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        return (n & mask) | (m << i);
    }
}