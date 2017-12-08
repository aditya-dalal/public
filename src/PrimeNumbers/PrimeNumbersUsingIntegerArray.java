package primeNumbers;

import java.util.Scanner;

public class PrimeNumbersUsingIntegerArray
{
    static int[] numberList;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        numberList = new int[limit];

        long startTime = System.nanoTime();
        System.out.println("count: " + findPrimes(limit));
        long totalTime = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Total time(ms): " + totalTime);
    }

    private static int findPrimes(int number)
    {
        for(int i=0; i < number; i++)
        {
            numberList[i] = i+1;
        }

        numberList[0] = 0;
        for(Integer value : numberList)
        {
            if(value == 0)
                continue;
            else
            {
                for(int i = 2; i < numberList.length; i++)
                {
                    int index = (value * i) - 1;
                    if(index >= (numberList.length))
                        break;
                    numberList[index] = 0;
                }
            }
        }

        int count = 0;
        for(Integer value : numberList)
        {
            if(value != 0) {
                count++;
                System.out.print(value + " ");
            }
        }
        System.out.println();
        return count;
    }
}
