package crackingCodingInterview.arraysAndStrings;

public class StringRotationCheck
{
	public static void main(String[] args)
	{
		String str1 = "abcd";
		String str2 = "cdab";

		System.out.println(checkIfRotation(str1, str2));
	}

	public static boolean checkIfRotation(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		String str2str2 = str2+str2;
		return str2str2.contains(str1);
	}
}