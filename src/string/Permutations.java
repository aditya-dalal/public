package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 04/05/16.
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(permutations("abcd"));
    }

    public static List<String> permutations(String str) {
        if (str.length() == 0)
            return null;
        List<String> perms = new ArrayList<>();
        perms.add(Character.toString(str.charAt(0)));
        if (str.length() == 1)
            return perms;
        return getPerms(perms, str, str.substring(0, 2));
    }

    public static List<String> getPerms(List<String> perms, String str, String substr) {
        char last = substr.charAt(substr.length() - 1);
        List<String> strs = new ArrayList<>();
        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                StringBuilder str1 = new StringBuilder(perm);
                strs.add((str1.insert(i, last)).toString());
            }
        }
        if (!str.equals(substr))
            strs = getPerms(strs, str, str.substring(0, substr.length() + 1));
        return strs;
    }
}
