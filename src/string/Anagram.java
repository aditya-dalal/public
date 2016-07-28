package string;

public class Anagram
{
    public static void main(String[] args)
    {
        String str = "abc";

        anagram("", str);
    }

    private static void anagram(String prefix, String str)
    {
        int length = str.length();
        if(length == 0)
            System.out.println(prefix);
        else
            for (int i = 0; i < length; i++)
                anagram(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
    }
}
