package diamond;

import java.util.Scanner;

public class Diamond
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        diamond(Integer.parseInt(scanner.nextLine()));
    }

    private static void diamond(int height)
    {
        int midLow = 0, midHigh = 0;
        for(int i = 0; i < height; i++)
        {
            if(i <= height/2)
            {
                midLow = height/2 - i-1;
                midHigh = height/2 + i+1;
            }
            else
            {
                midLow ++;
                midHigh --;
            }
            for(int j = 0; j < height; j++)
            {
                if(j <= midLow)
                    System.out.print(" ");
                else if(j >= midHigh)
                    System.out.print("");
                else
                    System.out.print("*");
            }
            System.out.println("");
        }

    }
}

