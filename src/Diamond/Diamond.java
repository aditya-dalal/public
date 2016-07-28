package diamond;

import java.util.Scanner;

public class Diamond
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        diamond(height);
        diamond2(height);
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

    private static void diamond2(int height)
    {
        int mid = height / 2;

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < height; j++)
            {
                if(i <= mid)
                {
                    if(j >= mid - i && j <= mid + i)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                else
                {
                    if(j >= i - mid && j < height - i + mid)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

