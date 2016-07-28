package GoogleCodeJam;

import java.io.*;
import java.util.Scanner;

public class PartElf
{
    public static void main(String[] args)
    {
        Scanner scanner = null;
        BufferedWriter writer = null;
        try {
            scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= testCases; i++)
            {
                String[] input = scanner.nextLine().split("/");
                long numerator =  Long.parseLong(input[0]);
                long denominator = Long.parseLong(input[1]);

                if (denominator % 2 != 0 || numerator >= denominator)
                    writer.write("Case #" + i + ": impossible" + "\n");
                else
                {
                    int power = 1;
                    for(; power <= 40; power++)
                    {
                        long temp = numerator * (long) Math.pow(2, power);
                        if( temp < denominator)
                            continue;
                        if(temp / denominator == 1 && (temp % denominator) % 2 == 0)
                        {
                            writer.write("Case #" + i + ": " + power + "\n");
                            break;
                        }
                    }

                    if(power > 40)
                        writer.write("Case #" + i + ": impossible" + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printResult(int caseNum, String value)
    {
        System.out.println("Case #" + caseNum + ": " + value);
    }
}
