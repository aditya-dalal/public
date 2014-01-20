package problems;

import java.util.*;

public class NQueens
{
    static int size = 12;
    static boolean [][] board = new boolean[size][size];
    static int count = 0;
    static Stack<Integer> lastRow = new Stack<Integer>();
    static Stack<Integer> lastColumn = new Stack<Integer>();
    static int iterations = 0;

    public static void main(String[] args)
    {
        placeQueen(0, 0);
        printBoard();
        System.out.println("Iterations: " + iterations);
    }

    public static boolean placeQueen(int row, int column)
    {
        iterations++;
        if(count == size)
            return true;
        else if(column > size-1)
        {
            if(lastRow.empty())
                return false;
            board[lastRow.peek()][lastColumn.peek()] = false;
            count--;
            placeQueen(lastRow.pop(), lastColumn.pop() + 1);
        }
        else
        {
            if(checkValidPosition(row,column))
            {
                board[row][column] = true;
                lastRow.push(row);
                lastColumn.push(column);
                count++;
                placeQueen(row+1, 0);
            }
            else
            {
                placeQueen(row, column+1);
            }
        }
        return false;
    }

    private static boolean checkValidPosition(int row, int column)
    {
        for(int i = row; i >= 0; i--)
            if(board[i][column] == true)
                return false;

        for(int i = column; i >= 0; i--)
            if(board[row][i] == true)
                return false;

        for (int i = row-1, j = column-1; (i >= 0 && j >= 0) ; i--, j--)
            if(board[i][j] == true)
                return false;

        for(int i = row-1, j = column+1; (i >= 0 && j < size); i--, j++)
            if(board[i][j] == true)
                return false;

        return true;
    }

    private static void printBoard()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(board[i][j] ? "Q " : "* ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

}
