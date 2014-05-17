package crackingCodingInterview.arraysAndStrings;

public class RemoveDuplicateChars
{
    public static void main(String[] args)
    {
        String str = "abcabcabcd";
        System.out.println(removeDuplicate(str));
        System.out.println(removeDuplicate1(str));
        System.out.println(removeDuplicate2(str));
    }

    public static String removeDuplicate(String str)
    {
        StringBuilder result = new StringBuilder();
        char[] charArray = str.toCharArray();
        for(int i = 0; i < str.length(); i++)
        {
            if(charArray[i] != 0)
                result.append(charArray[i]);
            else
                continue;
            for(int j = i + 1; j < str.length(); j++)
            {
                if(charArray[i] == charArray[j])
                    charArray[j] = 0;
            }
        }
        return result.toString();
    }

    public static String removeDuplicate1(String str)
    {
        int index = 0;
        char[] charArray = str.toCharArray();
        for(int i = 0; i < str.length() - 1; i++)
        {
            char temp = charArray[i];
            if(charArray[i] != 0)
            {
                charArray[i] = 0;
                charArray[index] = temp;
                index++;
            }
            else
                continue;
            for(int j = i + 1; j < str.length(); j++)
            {
                if(temp == charArray[j])
                    charArray[j] = 0;
            }
        }
        return String.valueOf(charArray);
    }

    public static String removeDuplicate2(String str)
    {
        boolean[] ascii = new boolean[256];
        StringBuilder result = new StringBuilder();
        for(char val : str.toCharArray())
        {
            if(ascii[val] != true)
            {
                result.append(val);
                ascii[val] = true;
            }
        }
        return result.toString();
    }

}
