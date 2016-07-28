package GooglePractice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreCredit
{
    public static void main(String[] args)
    {
        Scanner scanner = null;
        BufferedWriter writer;
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        try {
            scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));
            int testCases = scanner.nextInt();

            for(int i = 1; i <= testCases; i++)
            {
                int credit = scanner.nextInt();
                int intCount = scanner.nextInt();
                int value;
                for(int j = 1; j <= intCount; j++)
                {
                    value = scanner.nextInt();
                    if(integerMap.containsKey(credit-value))
                    {
                        writer.write("Case #" + i + ": " + integerMap.get(credit-value) + " " + j + "\n");
                        scanner.nextLine();
                        break;
                    }
                    else if(!integerMap.containsKey(value))
                        integerMap.put(value, j);
                }
                integerMap.clear();
            }
        writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
