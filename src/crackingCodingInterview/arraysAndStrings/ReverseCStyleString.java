package crackingCodingInterview.arraysAndStrings;

public class ReverseCStyleString
{
	public static void main(String[] args)
	{
		String str = "abcdefg%";
		System.out.println(reverseString(str));
	}

	public static String reverseString(String str)
	{
		char[] charArr = str.toCharArray();
		for(int i = 0, j = str.length()-2; i <= j; i++, j--)
		{
			char temp = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = temp;
		}
		return String.valueOf(charArr);
	}
}
