package primeNumbers;

import java.util.Scanner;

public class PrimeNumbersUsingBooleanArray
{
    static boolean[] numberList;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        numberList = new boolean[limit];

        long startTime = System.nanoTime();
        System.out.println(findPrimes(limit));
        long totalTime = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Total time(ms): " + totalTime);
    }

    private static int findPrimes(int number)
    {
        for(int i=0; i < number; i++)
        {
            numberList[i] = true;
        }

        numberList[0] = false;
        for(int value = 1; value < numberList.length; value ++)
        {
            if(numberList[value] == false)
                continue;
            else
            {
                for(int i = 2; i < numberList.length; i++)
                {
                    int index = ((value + 1) * i) - 1;
                    if(index >= (numberList.length))
                        break;
                    numberList[index] = false;
                }
            }
        }

        int count = 0;
        for(Boolean value : numberList)
        {
            if(value == true)
                count++;
        }
        return count;
    }
}
