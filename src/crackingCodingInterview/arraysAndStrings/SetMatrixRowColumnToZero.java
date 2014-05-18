package crackingCodingInterview.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixRowColumnToZero
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,0,1,1},
                {1,1,1,1},
                {1,1,0,1},
                {1,1,1,1}
        };

        printMatrix(matrix);
        System.out.println();
        replaceRowColumnsWithZero(matrix);
        printMatrix(matrix);
    }

    public static void replaceRowColumnsWithZero(int[][] matrix)
    {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j< matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int row : rows)
            for(int col = 0; col < matrix[0].length; col++)
                matrix[row][col] = 0;

        for(int col : cols)
            for(int row = 0; row < matrix.length; row++)
                matrix[row][col] = 0;
    }

    public static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j< matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}