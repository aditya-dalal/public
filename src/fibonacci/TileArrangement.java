package fibonacci;

public class TileArrangement
{
    // In how many ways can you fill 2Xn board using 2X1 blocks.
    // Ans: 2X1 = 1, 2X2 = 2, 2X3 = 3, 2X4 = 5, 2X5 = 8 .... nth fibonacci number for 2Xn.

    public static void main(String[] args)
    {
        int boardLength = 10;
        System.out.println(getFibonacciNumberFor(boardLength + 1));
        System.out.println(fibonacciRecursion(boardLength + 1));
    }

    private static long getFibonacciNumberFor(int index)
    {
        long previous = 0;
        long result = 1;
        long temp = 0;
        if(index <= 1)
            return 0;
        else
        {
            for(int i = 1; i < index; i++)
            {
                temp = result;
                result = previous + result;
                previous = temp;
            }
            return result;
        }
    }

    private static long fibonacciRecursion(int index)
    {
        if(index == 0)
            return 0;
        else if(index == 1)
            return 1;
        else
            return fibonacciRecursion(index - 1) + fibonacciRecursion(index - 2);
    }
}
