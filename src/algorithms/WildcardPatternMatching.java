package algorithms;

/**
 * Created by aditya.dalal on 20/03/18.
 */
public class WildcardPatternMatching {
    public static void main(String[] args) {
        String str = "baaabab";
//        String pattern = "*****ba*****ab";
        String pattern = "ba*****ab";
//        String pattern = "*a?ba?a";
        System.out.println(patternMatch(str, pattern, str.length(), pattern.length()));
    }

    static boolean patternMatch(String str, String pattern, int n, int m)
    {
        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }
        print(lookup, str, pattern);

        return lookup[n][m];
    }

    static void print(boolean[][] arr, String str, String pattern) {
        System.out.print("\t\t\t");
        for(int j = 0; j < pattern.length(); j++)
            System.out.print(pattern.charAt(j) + "\t\t");
        System.out.println();
        str = " " + str;
        for(int i=0; i < arr.length; i++) {
            System.out.print(str.charAt(i) + "\t");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
