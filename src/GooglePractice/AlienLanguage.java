package GooglePractice;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AlienLanguage
{
    static Character[][] charArray;
    Stack<Integer> rowStack = new Stack<Integer>();
    Stack<Integer> colStack = new Stack<Integer>();

    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));

            int rows = scanner.nextInt();
            int totalWords = scanner.nextInt();
            int testCases = scanner.nextInt();
            scanner.nextLine();
            Map<String, Boolean> words = new LinkedHashMap<String, Boolean>();

            for(int i = 0; i < totalWords; i++)
                words.put(scanner.nextLine(), true);

            for(int i = 1; i <= testCases; i++)
            {
                char[] testCase = scanner.nextLine().toCharArray();
                int cols = rows, count = 0;
                boolean start = false;

                for(char character : testCase)
                {
                    if(character != '(' && start)
                        count++;
                    else if(character == '(')
                        start = true;
                    else if(character == ')')
                    {
                        if(count > cols)
                            cols = count;
                        count = 0;
                        start = false;
                    }
                }
                charArray = new Character[rows][cols];

                int row = 0, col = 0;
                for (char character : testCase)
                {
                    if(character == '(')
                        start = true;
                    else if(character == ')')
                    {
                        row++; col = 0;
                        start = false;
                    }
                    else if(start == false)
                    {
                        charArray[row][col] = character;
                        row++; col = 0;
                    }
                    else
                        charArray[row][col++] = character;
                }
                checkWords();
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkWords()
    {
        for(int col = 0; col < charArray[0].length; col++)
        {
            for(int row = 0; row < charArray.length; row++)
            {

            }
        }
    }

    private static void checkWords1(int row, int col, String word)
    {
        if(row == charArray.length-1 && col < charArray[0].length)
        {
            if(charArray[row][col] != null)
            {
                word += charArray[row][col];
                System.out.println(word);
                checkWords1(row, col+1, word.substring(0, word.length()-1));
            }

        }
        else if(row < charArray.length -1)
        {
            checkWords1(row+1, col, word + charArray[row][col]);
        }
    }
}
