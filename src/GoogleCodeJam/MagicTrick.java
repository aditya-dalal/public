package GoogleCodeJam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicTrick
{
    public static void main(String[] args)
    {
        BufferedWriter writer = null;
        try {
            Scanner scanner = new Scanner(new File("/tmp/input.in"));
            writer = new BufferedWriter(new FileWriter("/tmp/output.txt"));

            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++)
            {
                String[] firstRow = getCards(scanner);
                String[] secondRow = getCards(scanner);

                List<String> matches = getMatchingCards(firstRow, secondRow);

                if(matches.size() == 1)
                    writer.write("Case #" + i + ": " + matches.get(0) + "\n");
                else if (matches.size() > 1)
                    writer.write("Case #" + i + ": Bad magician!\n");
                else
                    writer.write("Case #" + i + ": Volunteer cheated!\n");

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

    private static List<String> getMatchingCards(String[] firstRow, String[] secondRow) {
        List<String> matches = new ArrayList<String>();
        for (String first : firstRow)
            for (String second : secondRow)
                if(first.equals(second))
                    matches.add(first);
        return matches;
    }

    private static String[] getCards(Scanner scanner) {
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        String[] cardStrings = new String[4];

        for(int row = 0; row < 4; row++)
        {
            if(row != rowNumber-1)
                scanner.nextLine();
            else
                cardStrings = scanner.nextLine().split(" ");
        }
        return cardStrings;
    }
}
