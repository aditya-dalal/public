package crackingCodingInterview.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class StringAnagrams
{
    public static void main(String[] args)
    {
        String str1 = "aabb";
        String str2 = "abab";
        System.out.println(areAnagrams(str1, str2));
    }

    public static boolean areAnagrams(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(char val : str1.toCharArray())
        {
            if(charMap.get(val) != null)
                charMap.put(val, charMap.get(val) + 1);
            else
                charMap.put(val, 1);
        }

        for(char val : str2.toCharArray())
        {
            if(charMap.get(val) == null)
                return false;
            charMap.put(val, charMap.get(val) - 1);
        }

        for(char val : charMap.keySet())
        {
            if(charMap.get(val) != 0)
                return false;
        }
        return true;
    }
}
