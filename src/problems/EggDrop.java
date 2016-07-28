package problems;

public class EggDrop
{
    public static void main(String[] args)
    {
        int floors = 10;
        int eggs = 10;

        int[][] memo = new int[eggs+1][floors+1];

        System.out.println(eggDrop(eggs, floors, memo));

        for (int i = 1; i <= eggs; i++)
        {
            for (int j = 1; j <= floors; j++)
                System.out.print(memo[i][j] + " ");
            System.out.println();
        }
    }

    private static int eggDrop(int eggs, int floors, int[][] memo)
    {
        if(eggs <= 1 )
        {
            memo[eggs][floors] = floors;
            return floors;
        }
        if(floors <= 1)
        {
            memo[eggs][floors] = 1;
            return 1;
        }
        int min = floors+1;
        for (int x = 1; x < floors; x++)
        {
            int a = memo[eggs-1][x-1] != 0 ? memo[eggs-1][x-1] : eggDrop(eggs - 1, x - 1, memo);
            int b = memo[eggs][floors-x] != 0 ? memo[eggs][floors-x] : eggDrop(eggs, floors - x, memo);
            int result = Math.max(a, b);
            if(result < min)
                min = result;
        }
        memo[eggs][floors] = min+1;
        return  min + 1;
    }
}
