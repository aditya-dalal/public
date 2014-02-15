package algorithms;

import java.util.Arrays;

public class CountingSort
{
    public static void main(String[] args)
    {
//        Integer[] arr = {17,27,3,16,13,10,1,5,7,12,4,8,9,0};
        Integer[] arr = {2,5,3,0,2,3,0,3,3,5,0,5,3};
        Integer[] result = new Integer[arr.length];

        countingSort(arr, result);
        System.out.println(Arrays.asList(result));
    }

    private static void countingSort(Integer[] arr, Integer[] result)
    {
        int largest = 0;

        for(int value : arr)
        {
            if(value > largest)
                largest = value;
        }
        largest++;

        int[] count = new int[largest];

        for(int i = 0; i < arr.length; i++)
        {
            count[arr[i]] = count[arr[i]] + 1;
        }

        for(int i = 1; i < count.length; i++)
        {
            count[i] = count[i] + count[i-1];
        }

        for(int i = 0; i < arr.length; i++)
        {
            result[count[arr[i]] - 1] = arr[i];
            count[arr[i]] = count[arr[i]] - 1;
        }
    }
}
