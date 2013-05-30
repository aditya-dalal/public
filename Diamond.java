package Test;

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int value = Integer.parseInt(scanner.nextLine());

        diamond(value);

    }

    static void diamond(int h)
    {
        String[][] matrix = new String[h][h];
        for(int i = 0; i < h; i++)
        {
            for(int j= 0; j < h ; j++)
            {
                matrix[i][j] = "*";
            }
        }

        for(int i = 0; i < h/2; i++)
        {
            int midLow = h/2 - i-1;
            int midHigh = h/2 + i+1;
            for(; midLow >= 0; midLow--, midHigh++)
            {
                matrix[i][midLow] = " ";
                matrix[i][midHigh] = "";
            }

        }

        for(int i = h-1, j = 0; i > h/2; i--, j++)
        {
            int midLow = h/2 - j-1;
            int midHigh = h/2 + j+1;
            for(; (midLow >= 0); midLow--, midHigh++)
            {
                matrix[i][midLow] = " ";
                matrix[i][midHigh] = "";
            }

        }

        for(int i =0; i<h; i++)
        {
            for(int j=0; j < h ; j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
}

