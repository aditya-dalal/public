package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringSimilarity
{
    public static void main(String[] args) throws Exception
    {
        List<String> strings = new ArrayList<String>();

        try
        {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        int testCases = Integer.parseInt(bufferRead.readLine());
            for(int i = 0; i < testCases; i++)
            {
                strings.add(bufferRead.readLine());
            }
            bufferRead.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        for(String str : strings)
        {
            getSimilarity(str);
        }
    }

    // Z algorithm to find string similarity in O(n)

    private static void getSimilarity(String str)
    {
        char[] chars = str.toCharArray();
        int[] z = new int[str.length()];
        int n = str.length();
        int left = 0, right = 0;
        for (int i = 1; i < n; i++)
        {
            if (i > right)
            {
                left = right = i;
                while (right < n && chars[right-left] == chars[right])
                    right++;
                z[i] = right-left;
                right--;
            }
            else
            {
                int k = i-left;
                if (z[k] < right-i+1)
                    z[i] = z[k];
                else
                {
                    left = i;
                    while (right < n && chars[right-left] == chars[right])
                        right++;
                    z[i] = right-left;
                    right--;
                }
            }
        }

        long count = n;
        for (int i = 1; i < n; i++)
            count += z[i];
        System.out.println(count);
    }
}
