package crackingCodingInterview.arraysAndStrings;

import java.util.*;

public class StringHasUniqueChars
{
    public static void main(String[] args)
    {
        String str = "abcdefa";
        System.out.println(bruteForce(str));
        System.out.println(booleanArray(str));
        System.out.println(usingBitManipulation(str));  // Works only for alphabets
        System.out.println(usingSort(str));
        System.out.println(usingMap(str));
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
        long checker = 0;
        for(int i = 0; i < str.length(); i++)
        {
            int val = str.charAt(i) - 'A';
            long temp = (long)1 << val;
            if((checker & temp) > 0)
                return false;
            checker |= temp;
        }
        return true;
    }

    public static boolean usingSort(String str)
    {
        List<Character> charArray = new ArrayList<Character>();
        for(char val : str.toCharArray())
            charArray.add(val);
        Collections.sort(charArray);
        for(int i = 0; i < str.length() - 1; i++)
        {
            if(charArray.get(i) == charArray.get(i+1))
                return false;
        }
        return true;
    }

    public static boolean usingMap(String str)
    {
        Map<Character, Boolean> charCountMap = new HashMap<Character, Boolean>();
        for(char val : str.toCharArray())
        {
            if(charCountMap.get(val) != null)
                return false;
            charCountMap.put(val, true);
        }
        return true;
    }

}
