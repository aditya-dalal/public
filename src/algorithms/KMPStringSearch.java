package algorithms;

/**
 * Created by aditya.dalal on 31/10/17.
 */
public class KMPStringSearch {

    public static void main(String[] args) {
        String line = "aabaaba";
        String pattern = "aaba";
        int j = 0;
        int[] lps = longestPrefixSuffix(pattern);
        for (int i = 0; i < line.length(); ) {
            if (line.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if(j == pattern.length()) {
                    System.out.println("found at index: " + (i - pattern.length()));
                    j = lps[j-1];
                }
            }
            else if(j > 0)
                j = lps[j-1];
            else
                i++;
        }
        for (int i : longestPrefixSuffix(pattern))
            System.out.print(i + " ");
    }

    private static int[] longestPrefixSuffix(String pattern) {
        int len = 0;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        for(int i = 1; i < pattern.length();) {
            if(pattern.charAt(i) == pattern.charAt(len))
                lps[i++] = ++len;
            else if(len > 0)
                len = lps[len-1];
            else
                lps[i++] = len;
        }
        return lps;
    }

}

