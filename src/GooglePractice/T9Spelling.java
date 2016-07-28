package GooglePractice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T9Spelling
{
    public static void main(String[] args)
    {
        Map<Character, Integer> charIntMap = new HashMap<Character, Integer>();
        charIntMap.put('a', 2);
        charIntMap.put('b', 22);
        charIntMap.put('c', 222);
        charIntMap.put('d', 3);
        charIntMap.put('e', 33);
        charIntMap.put('f', 333);
        charIntMap.put('g', 4);
        charIntMap.put('h', 44);
        charIntMap.put('i', 444);
        charIntMap.put('j', 5);
        charIntMap.put('k', 55);
        charIntMap.put('l', 555);
        charIntMap.put('m', 6);
        charIntMap.put('n', 66);
        charIntMap.put('o', 666);
        charIntMap.put('p', 7);
        charIntMap.put('q', 77);
        charIntMap.put('r', 777);
        charIntMap.put('s', 7777);
        charIntMap.put('t', 8);
        charIntMap.put('u', 88);
        charIntMap.put('v', 888);
        charIntMap.put('w', 9);
        charIntMap.put('x', 99);
        charIntMap.put('y', 999);
        charIntMap.put('z', 9999);
        charIntMap.put(' ', 0);

        try {
            Scanner scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));

            int testCases = Integer.parseInt(scanner.nextLine());

            for(int i = 1; i <= testCases; i++)
            {
                writer.write("Case #" + i + ": ");
                char[] chars = scanner.nextLine().toCharArray();
                int previous = -1, current;

                for(char character : chars)
                {
                    current = charIntMap.get(character) % 10;
                    if(current == previous)
                        writer.write(" ");
                    writer.write(charIntMap.get(character).toString());
                    previous = current;
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
