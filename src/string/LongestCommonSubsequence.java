package string;

public class LongestCommonSubsequence
{
    public static void main(String[] args)
    {
        String str1 = "abcbdab";
        String str2 = "bdcaba";

        longestCommonSubsequence(str1, str2);
    }

    private static void longestCommonSubsequence(String str1, String str2)
    {
        int[][] memo = new int[str1.length()+1][str2.length()+1];
        char[][] direction = new char[str1.length()+1][str2.length()+1];

        for(int i = 0; i < str1.length()+1; i++)
            memo[i][0] = 0;
        for(int j = 0; j < str2.length()+1; j++)
            memo[0][j] = 0;
        for(int i = 1; i <= str1.length(); i++)
        {
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    memo[i][j] = memo[i-1][j-1] + 1;
                    direction[i][j] = 'd';
                }
                else if(memo[i-1][j] >= memo[i][j-1])
                {
                    memo[i][j] = memo[i-1][j];
                    direction[i][j] = 'u';
                }
                else
                {
                    memo[i][j] = memo[i][j-1];
                    direction[i][j] = 'l';
                }
            }
        }

        subsequence(str1, direction, memo.length-1, memo[0].length-1);
    }

    private static void subsequence(String str, char[][] direction, int row, int column)
    {
        if(row == 0 || column == 0)
            return;
        if(direction[row][column] == 'u')
            subsequence(str,direction,row-1,column);
        else if(direction[row][column] == 'l')
            subsequence(str, direction, row,column-1);
        else
        {
            subsequence(str,direction,row-1,column-1);
            System.out.println(str.charAt(row-1));
        }
    }

}
