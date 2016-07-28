package GooglePractice;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RopeIntranet
{
    public static void main(String[] args)
    {
        Scanner scanner = null;
        BufferedWriter writer = null;
        try {
            scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));
            int testCases = scanner.nextInt();

            for(int i = 1; i <= testCases; i++)
            {
                int wires = scanner.nextInt();
                Map<Integer, Integer> wireMap = new LinkedHashMap<Integer, Integer>();

                for(int floor = 0; floor < wires; floor++)
                    wireMap.put(scanner.nextInt(), scanner.nextInt());

                int count = 0;
                for (int wire1 : wireMap.keySet())
                {
                    for (int wire2 : wireMap.keySet())
                    {
                        if (wire2 < wire1 && wireMap.get(wire2) > wireMap.get(wire1))
                            count++;
                        if (wire2 > wire1 && wireMap.get(wire2) < wireMap.get(wire1))
                            count++;
                    }
                }

                writer.write("Case #" + i + ": " + count/2 + "\n");
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
}
