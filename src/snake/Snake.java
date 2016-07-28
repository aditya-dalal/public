package snake;

public class Snake
{
    public static void main(String[] args)
    {
        String[][] layout = new String[10][10];

        for(int row = 0; row < layout.length; row++)
        {
            for(int col = 0; col < layout[row].length; col++)
            {
                layout[row][col] = "*";
            }
        }

        for(String[] row : layout)
        {
            for (String col : row)
                System.out.print(" " + col);
            System.out.println("");
        }
    }

}
