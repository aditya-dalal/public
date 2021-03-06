package algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort
{
    public static void main(String[] args)
    {
        Integer[] arr = {17,27,3,16,13,10,1,5,7,12,4,8,9,0};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.asList(arr));

    }

    private static void quickSort(Integer[] arr, int min, int max)
    {
        if(min < max)
        {
            int mid = partition(arr, min, max);
            quickSort(arr, min, mid - 1);
            quickSort(arr, mid + 1, max);
        }
    }

    private static int partition(Integer[] arr, int min, int max)
    {
        int pivotIndex = getRandomIndex(min, max);
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[max];
        arr[max] = temp;

        int value = arr[max];
        int index = min - 1;

        for(int i = min; i < max; i++)
        {
            if(arr[i] <= value)
            {
                index++;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        index++;
        temp = arr[index];
        arr[index] = value;
        arr[max] = temp;
        return index;
    }

    public static int partition1(Integer[] arr, int start, int end){
        int pivot = arr[end];
        int i = start, j = end;
        while(i < j){
            if(arr[i] > pivot){
                arr[j] = arr[i];
                arr[i] = arr[j-1];
                arr[j-1] = pivot;
                j--;
            }
            else
                i++;
        }
        return j;
    }

    private static int getRandomIndex(int min, int max)
    {
        return new Random().nextInt(max-min+1) + min;
    }
}
