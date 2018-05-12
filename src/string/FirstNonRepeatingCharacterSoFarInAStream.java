package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 19/03/18.
 */
public class FirstNonRepeatingCharacterSoFarInAStream {

    public static void main(String[] args) {
        String str = "geeksforgeeksandgeeksquizfor";
        firstNonRepeatingCharacterSoFar(str);
    }

    public static void firstNonRepeatingCharacterSoFar(String str) {
        boolean[] chars = new boolean[256];
        List<Character> charList = new ArrayList<>();

        for(char c: str.toCharArray()) {
            System.out.println("Reading "+ c +" from stream");
            if(!chars[c]) {
                chars[c] = true;
                charList.add(c);
            }
            else if(c != charList.get(0))
                charList.remove((Character) c);
            else
                charList.remove(0);
            System.out.println("First non-repeating character so far is: " + charList.get(0));
        }
    }
}
