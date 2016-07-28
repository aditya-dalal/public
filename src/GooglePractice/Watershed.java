package GooglePractice;

import java.io.*;
import java.util.Scanner;

public class Watershed
{
    static char [] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static int charIndex;

    public static void main(String[] args)
    {
        BufferedWriter writer = null;
        try {
            Scanner scanner = new Scanner(new File("/Users/aditya.dalal/input.in"));
            writer = new BufferedWriter(new FileWriter("/Users/aditya.dalal/Downloads/output.txt"));

            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++)
            {
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                int[][] map = new int[rows][cols];
                Character[][] watershed = new Character[rows][cols];
                charIndex = 0;

                for (int row = 0; row < rows; row++)
                    for (int col = 0; col < cols; col++)
                        map[row][col] = scanner.nextInt();

                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        if(watershed[row][col] == null)
                            dfsVisit(map, watershed, row, col);
                    }
                }

                writer.write("Case #" + i + ":\n");
                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        writer.write(watershed[row][col].toString() + " ");
                    }
                    writer.write("\n");
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

    private static Character dfsVisit(int[][] map, Character[][] watershed, int row, int col)
    {
        if(watershed[row][col] != null)
            return watershed[row][col];

        int neighbourVal = map[row][col];
        int neighbourRow = row;
        int neighbourCol = col;

        if(row - 1 >= 0 && map[row - 1][col] < neighbourVal)
        {
            neighbourVal = map[row - 1][col];
            neighbourRow = row-1;
            neighbourCol = col;
        }
        if(col - 1 >= 0 && map[row][col - 1] < neighbourVal)
        {
            neighbourVal = map[row][col - 1];
            neighbourRow = row;
            neighbourCol = col-1;
        }
        if(col + 1 < map[0].length && map[row][col + 1] < neighbourVal)
        {
            neighbourVal = map[row][col + 1];
            neighbourRow = row;
            neighbourCol = col+1;
        }
        if(row + 1 < map.length && map[row + 1][col] < neighbourVal)
        {
            neighbourRow = row+1;
            neighbourCol = col;
        }

        if(row == neighbourRow && col == neighbourCol)
        {
            watershed[row][col] = alphabets[charIndex++];
            return watershed[row][col];
        }

        return watershed[row][col] = dfsVisit(map, watershed, neighbourRow, neighbourCol);
    }
}
