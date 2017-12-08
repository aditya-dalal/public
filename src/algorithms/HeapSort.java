package algorithms;

import java.util.Arrays;

public class HeapSort
{
    public static void main(String[] args)
    {
        Integer arr[] = {3,5,1,2,12,8,6,11,4,9,7,10};

        heapify(arr);
        System.out.println(Arrays.asList(arr));
        heapSort(arr);
        System.out.println(Arrays.asList(arr));
    }

    private static void heapSort(Integer[] arr)
    {
        heapify(arr);
        int temp;
        for(int i = arr.length - 1; i > 0 ; i--)
        {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, 0, i - 1);
        }
    }

    public static void heapify(Integer[] arr)
    {
        for(int index = (arr.length - 1) / 2; index >= 0; index--)
            maxHeapify(arr, index, arr.length - 1);
    }

    public static void maxHeapify(Integer[] arr, int index, int length)
    {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int larger = index;

        if(leftIndex <= length && arr[leftIndex] > arr[larger])
            larger = leftIndex;
        if(rightIndex <= length && arr[rightIndex] > arr[larger])
            larger = rightIndex;
        if(larger != index)
        {
            int temp = arr[index];
            arr[index] = arr[larger];
            arr[larger] = temp;
            maxHeapify(arr, larger, length);
        }
    }

}
