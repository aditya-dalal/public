package temp;



/**
 * Created by aditya.dalal on 17/09/17.
 */
public class Temp2 {
    public static void main(String[] args) throws Exception {

        String str = "aabaaba";
        String pattern = "aaba";

        int[] lps = getLongestPrefixSuffix(pattern);
        searchPattern(str, pattern, lps);
    }

    private static void searchPattern(String str, String pattern, int[] lps) {
        for(int i = 0, j = 0; i < str.length(); ) {
            if(str.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if(j == pattern.length()) {
                    System.out.println("Word found at: " + (i - j));
                    j = lps[j-1];
                }
            }
            else if(j > 0)
                j = lps[j-1];
            else
                i++;
        }
    }

    public static int[] getLongestPrefixSuffix(String pattern) {
        int[] lps = new int[pattern.length()];
        if(pattern.length() == 0)
            return lps;
        int len = 0;
        lps[len] = 0;
        for(int i = 1; i < pattern.length(); ) {
            if(pattern.charAt(len) == pattern.charAt(i))
                lps[i++] = ++len;
            else if(len > 0)
                len = lps[len-1];
            else
                lps[i++] = len;
        }
        return lps;
    }

}
