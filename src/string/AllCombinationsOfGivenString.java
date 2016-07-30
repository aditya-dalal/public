package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllCombinationsOfGivenString
{
    public static void main(String[] args)
    {
        String str = "abc";
        List<String> words = new ArrayList<>();

        char[] letters = str.toCharArray();

        long startTime = System.currentTimeMillis();

        for(char character : letters)
        {
            List<String> temp = new ArrayList<>();

            for(String word : words)
                temp.add(word + character);
            temp.add(String.valueOf(character));
            words.addAll(temp);
        }

        System.out.println("Time: " + (System.currentTimeMillis() - startTime));

        System.out.print(words);
        System.out.print(words.size());
    }

}
