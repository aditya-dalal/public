package GooglePractice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// This solution is wrong


public class WelcomeToCodeJam
{
    public static void main(String[] args)
    {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        char[] pattern = "welcome to code jam".toCharArray();

        for (char letter : pattern)
            charMap.put(letter, 0);

        BufferedWriter writer = null;
        try {
            Scanner scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));

            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= testCases; i++)
            {
                char[] line = scanner.nextLine().toCharArray();
                int[][] memo = new int[line.length+1][pattern.length+1];

                memo[0][0] = 1;
                for(int a = 0; a < line.length; a++)
                {
                    for (int b = 0; b < pattern.length; b++)
                    {
                        if(line[a] != pattern[b])
                            memo[a+1][b+1] = memo[a][b+1] % 10000;
                        else
                            memo[a+1][b+1] = memo[a][b+1] + memo[a][b] % 10000;
                    }
                }

//                System.out.print("  ");
//                for(int a = 0; a < pattern.length; a++)
//                    System.out.print(pattern[a] + " ");
//                System.out.println();
//
//                for (int a = 0; a < memo.length; a++)
//                {
//                    for (int b = 0; b < memo[0].length; b++)
//                        System.out.print(memo[a][b] + " ");
//                    if(a == 0)
//                        System.out.println();
//                    else
//                        System.out.println(line[a-1]);
//                }

                int result = 0;
                for(int a = 0; a <= line.length; a++)
                    result += memo[a][pattern.length];

                result += 10000;
                writer.write("Case #" + i + ": " + String.valueOf(result).substring(1) + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
