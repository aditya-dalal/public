package algorithms;

public class Knapsack
{
    public static void main(String[] args)
    {
        int[] weights = {2,3,1,4};
        int[] values = {50,30,40,10};
        int knapsack = 6;

        knapsackSolution(weights, values, knapsack);
    }

    private static void knapsackSolution(int[] weights, int[] values, int knapsackCapacity)
    {
        int[][] memo = new int[values.length+1][knapsackCapacity+1];

        for(int i = 0; i < knapsackCapacity; i++)
            memo[0][i] = 0;

        for(int i = 1; i < memo.length; i++)
        {
            for(int j = 0; j <= knapsackCapacity; j++)
            {
                if(weights[i-1] <= j)
                    memo[i][j] = Math.max(memo[i-1][j], values[i-1] + memo[i-1][j-weights[i-1]]);
                else
                    memo[i][j] = memo[i-1][j];
            }
        }

        int[] items = new int[values.length];
        for(int i = values.length, j = knapsackCapacity; i > 0 && j > 0;)
        {
            if(memo[i][j] != memo[i-1][j])
            {
                items[i-1] = 1;
                j = j - weights[i-1];
            }
            else
                items[i-1] = 0;
            i--;
        }

        System.out.print("Items to be selected: ");
        for (int i = 0; i < items.length; i++)
            if(items[i] == 1)
                System.out.print(i+1 + ", ");
        System.out.println("\nKnapsack total value: " + memo[values.length][knapsackCapacity]);
    }
}
