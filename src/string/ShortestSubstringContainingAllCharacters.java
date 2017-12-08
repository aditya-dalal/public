package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 18/02/17.
 */

public class ShortestSubstringContainingAllCharacters {

    // Given two strings s1, s2. find the smallest substring in s1 containing all characters of string s2 (in any order)
    // Example:
    // s1: "his is a test string"
    // s2: "tist"
    // Output: "t stri"

    public static void main(String[] args){
        System.out.println(shortStr("this is a test string", "tist"));
    }

    private static String shortStr(String input1, String input2) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : input2.toCharArray()) {
            if(charMap.get(c) == null)
                charMap.put(c, 1);
            else
                charMap.put(c, charMap.get(c) + 1);
        }
        Map<Character, Integer> counterMap = new HashMap<>();
        counterMap.putAll(charMap);

        int min = 0, counter = 0, index = 0;
        StringBuilder str = new StringBuilder();
        String result = null;

        for (int i = 0; i < input2.length(); i++) {
            char current = input1.charAt(i);
            if(charMap.get(current) != null) {
                str.append(current);
                counter++;
                index = i + 1;
                break;
            }
        }

        for (int i = index; i < input1.length(); i++) {
            char current = input1.charAt(i);
            str.append(current);
            if (charMap.get(current) != null && charMap.get(current) != 0) {
                counter++;
                charMap.put(current, charMap.get(current) - 1);
            }
            if (counter == input2.length()) {
                min = str.length();
                result = str.toString();
                index = i+1;
                break;
            }
        }

        if(result == null)
            return result;

        for(char c: result.toCharArray()) {
            if (charMap.get(c) != null)
                charMap.put(c, charMap.get(c) + 1);
        }

        for (int i = index; i < input1.length(); i++) {
            char current = input1.charAt(i);
            str.append(current);
            if(charMap.get(current) != null)
                charMap.put(current, charMap.get(current) + 1);
            if(current == str.charAt(0)) {
                str.deleteCharAt(0);
                charMap.put(current, charMap.get(current) - 1);
                while (true) {
                    char temp = str.charAt(0);
                    if(charMap.get(temp) == null) {
                        str.deleteCharAt(0);
                        continue;
                    }
                    if(charMap.get(temp) > counterMap.get(temp)) {
                        str.deleteCharAt(0);
                        charMap.put(temp, charMap.get(temp)-1);
                        continue;
                    }
                    break;
                }
                if(str.length() < min) {
                    result = str.toString();
                    min = str.length();
                }
            }
        }

        return result.toString();
    }
}
