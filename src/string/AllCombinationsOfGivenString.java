package string;

import java.util.HashSet;
import java.util.Set;

public class AllCombinationsOfGivenString
{
    public static void main(String[] args)
    {
        String str = "abcd";
        Set<String> words = new HashSet<String>();

        char[] letters = str.toCharArray();

        long startTime = System.currentTimeMillis();

        for(char character : letters)
        {
            Set<String> temp = new HashSet<String>();

            for(String word : words)
                temp.add(word + character);
            temp.add(String.valueOf(character));
            words.addAll(temp);
        }

        System.out.println("Time: " + (System.currentTimeMillis() - startTime));

        System.out.print(words);
    }

}
