package crackingCodingInterview.arraysAndStrings;

public class StringHasUniqueChars
{
	public static void main(String[] args)
	{
		String str = "abcdef";
		System.out.println(bruteForce(str));
		System.out.println(booleanArray(str));
        System.out.println(usingBitManipulation(str));  // Works only for lower case alphabets
    }

	public static boolean bruteForce(String str)
	{
		int length = str.length();
		for(int i = 0; i < length; i++)
		{
			for(int j = i + 1; j < length; j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean booleanArray(String str)
	{
		boolean[] boolArr = new boolean[256];
		for(char val : str.toCharArray())
		{
			if(boolArr[(int) val] == true)
				return false;
			else
				boolArr[(int) val] = true;
		}
		return true;
	}

    public static boolean usingBitManipulation(String str)
    {
        int checker = 0;
        for(int i = 0; i < str.length(); i++)
        {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0)
                return false;
            checker |= 1 << val;
        }
        return true;
    }
}
