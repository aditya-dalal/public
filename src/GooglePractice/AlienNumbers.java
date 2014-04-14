package GooglePractice;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AlienNumbers
{
    public static void main(String[] args)
    {
        BufferedWriter writer = null;
        try
        {
            Scanner scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/output.txt"));

            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= testCases; i++)
            {
                String[] input = scanner.nextLine().split(" ");
                String alienNumber = input[0];
                String sourceString = input[1];
                char[] targetLanguage = input[2].toCharArray();
                Map<Character, Integer> sourceLanguage = new LinkedHashMap<Character, Integer>();

                for (int j = 0; j < sourceString.length(); j++)
                    sourceLanguage.put(sourceString.charAt(j), j);

                int decimalValue = anyBaseToDecimal(alienNumber, sourceLanguage);
                String result = decimalToAnyBase(decimalValue, targetLanguage, "");
                writer.write("Case #" + i + ": " + result + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String decimalToAnyBase(int decimalValue, char[] targetLanguage, String str)
    {
        int base = targetLanguage.length;
        if(decimalValue/base != 0)
            return decimalToAnyBase(decimalValue/base, targetLanguage, str) + targetLanguage[decimalValue % base];
        return str + targetLanguage[decimalValue % base];
    }

    private static int anyBaseToDecimal(String alienNumber, Map<Character, Integer> sourceLanguage)
    {
        int value = 0;
        StringBuffer reverse = new StringBuffer(alienNumber).reverse();
        for (int i = 0; i < alienNumber.length(); i++)
            value += Math.pow(sourceLanguage.size(), i) * sourceLanguage.get(reverse.charAt(i));
        return value;
    }
}
