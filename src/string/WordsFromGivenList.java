package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordsFromGivenList
{
    public static void main(String[] args)
    {
        String[] wordList = {"cat", "act", "ac", "stop" , "cac", "", "sac"};
        char[] alphabetList = {'a', 'c', 't'};

        System.out.println(validWordsFromList(wordList, alphabetList));
    }

    private static Set<String> validWordsFromList(String[] wordList, char[] alphabetList)
    {
        Map<Character, Integer> charMapFromWord = new HashMap<Character, Integer>();
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        Set<String> validWords = new HashSet<String>();

        for(char character : alphabetList)
        {
            if(charMap.containsKey(character))
                charMap.put(character, charMap.get(character) + 1);
            else
                charMap.put(character, 1);
        }

        for(String word : wordList)
        {
            if((word.length() > charMap.size()) || (word.length() < 1))
                continue;

            for(char character : word.toCharArray())
            {
                if(charMapFromWord.containsKey(character))
                    charMapFromWord.put(character, charMapFromWord.get(character) + 1);
                else
                    charMapFromWord.put(character, 1);
            }

            boolean valid = true;
            for(char key : charMapFromWord.keySet())
            {
                if(charMap.containsKey(key))
                {
                    if(charMapFromWord.get(key) != charMap.get(key))
                    {
                        valid = false;
                        break;
                    }
                }
                else
                {
                    valid = false;
                    break;
                }
            }

            if(valid)
                validWords.add(word);
            charMapFromWord.clear();
        }
        return validWords;
    }
}
