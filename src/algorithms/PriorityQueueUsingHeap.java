package algorithms;

import java.util.Arrays;

public class PriorityQueueUsingHeap
{
    public static void main(String[] args)
    {
        Integer[] arr = {17,27,3,16,13,10,1,5,7,12,4,8,9,0};

        System.out.println(heapExtractMax(arr));
        System.out.println(Arrays.asList(arr));
        System.out.println(heapExtractMax(arr));
        System.out.println(Arrays.asList(arr));
    }

    private static int heapExtractMax(Integer[] arr)
    {
        heapify(arr);
        int max = arr[0];
        arr[0] = arr[arr.length - 1];
        maxHeapify(arr, 0, arr.length - 2);
        return max;
    }

    public static void heapify(Integer[] arr)
    {
        for(int i = (arr.length - 1) / 2; i >= 0; i--)
            maxHeapify(arr, i, arr.length - 1);
    }

    public static void maxHeapify(Integer[] arr, int index, int length)
    {
        int leftIndex = index * 2;
        int rightIndex = index * 2 + 1;
        int largest = index;

        if(leftIndex <= length && arr[leftIndex] > arr[largest])
            largest = leftIndex;
        if(rightIndex <= length && arr[rightIndex] > arr[largest])
            largest = rightIndex;

        if(index != largest)
        {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, length);
        }
    }
}
