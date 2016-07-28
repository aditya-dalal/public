package algorithms;

import java.util.Random;

public class KthSmallestElement
{
    public static void main(String[] args)
    {
        Integer[] arr = {17,27,3,16,13,10,1,5,7,12,4,8,9,0};

        quickSelect(arr, 0, arr.length-1, 10);
    }

    private static void quickSelect(Integer[] arr, int min, int max, int k)
    {
        if(min == max)
            System.out.println(arr[min]);
        else
        {
            int mid = partition(arr, min, max);
            if(k == mid)
                System.out.println(arr[mid]);
            else if(k-1 < mid)
                quickSelect(arr, min, mid - 1, k);
            else
                quickSelect(arr, mid + 1, max, k);
        }
    }

    private static int partition(Integer[] arr, int min, int max)
    {
        int pivotIndex = getRandomIndex(min, max);
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[max];
        arr[max] = temp;

        int pivot = arr[max];
        int index = min-1;

        for(int i = min; i < max; i++)
        {
            if(arr[i] < pivot)
            {
                index++;
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        index++;
        arr[max] = arr[index];
        arr[index] = pivot;
        return index;
    }

    private static int getRandomIndex(int min, int max)
    {
        return new Random().nextInt(max-min+1) + min;
    }
}
