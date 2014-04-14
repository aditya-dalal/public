package GooglePractice;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienLanguageUsingRegex
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));

            int rows = scanner.nextInt();
            int totalWords = scanner.nextInt();
            int testCases = scanner.nextInt();
            scanner.nextLine();

            String words = "";
            for(int i = 0; i < totalWords; i++)
                words += scanner.nextLine() + " ";

            for(int i = 1; i <= testCases; i++)
            {
                String line = scanner.nextLine().replaceAll("\\(", "[");
                line = line.replaceAll("\\)", "]");
                Pattern pattern = Pattern.compile(line);
                Matcher matcher = pattern.matcher(words);

                int count = 0;
                while (matcher.find())
                    count++;
                writer.write("Case #" + i + ": " + count + "\n");
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
