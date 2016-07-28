package GooglePractice;

import java.io.*;
import java.util.Scanner;

public class ReverseWords
{
    public static void main(String[] args)
    {
        Scanner scanner = null;
        BufferedWriter writer = null;
        try {
            scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));

            int testCases = Integer.parseInt(scanner.nextLine());

            for(int i = 1; i <= testCases; i++)
            {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                writer.write("Case #" + i + ":");
                for (int j = words.length-1; j >= 0; j--)
                {
                    writer.write(" " + words[j]);
                }
                writer.write("\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
