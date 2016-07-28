package GoogleCodeJam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChargingChaos
{
    public static void main(String[] args)
    {
        Scanner scanner = null;
                BufferedWriter writer = null;
                try {
                    scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
                    writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));
                    int testCases = scanner.nextInt();

                    for (int i = 1; i <= testCases; i++)
                    {
                        int devices = scanner.nextInt();
                        int switches = scanner.nextInt();

                        List<Integer> initial = new ArrayList<Integer>();
                        for(int a = 0; a < devices; a++)
                            initial.add(scanner.nextInt(2));

                        List<Integer> required = new ArrayList<Integer>();
                        for (int a = 0; a < devices; a++)
                            required.add(scanner.nextInt(2));

                        Collections.sort(initial);
                        Collections.sort(required);
                        for (int a = 0; a < devices; a++)
                        {
                            System.out.print(Integer.toBinaryString(initial.get(a)) + " ");
                            System.out.println(Integer.toBinaryString(required.get(a)));
                        }

                        int count = 0;
                        for(int x = 0; x <= devices; x++)
                        {

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
}
