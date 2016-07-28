package algorithms;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        Integer[] arr = {4,6,2,7,0,9,3,1,5,8};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.asList(arr));
    }

    private static void mergeSort(Integer[] arr1, int min, int max)
    {
        if(min < max)
        {
            int mid = (min + max) / 2;
            mergeSort(arr1, min, mid);
            mergeSort(arr1, mid+1, max);
            merge(arr1, min, mid, max);
        }
    }

    private static void merge(Integer[] arr1, int min, int mid, int max)
    {
        Integer[] left = new Integer[mid - min + 1];
        Integer[] right = new Integer[max - mid];

        for(int i = 0; i < left.length; i++)
            left[i] = arr1[min+i];
        for(int i = 0; i < right.length; i++)
            right[i] = arr1[mid + i + 1];

        int i = 0, j = 0, k = min;
        while (i < left.length && j < right.length)
        {
            if(left[i] < right[j])
                arr1[k++] = left[i++];
            else if(left[i] > right[j])
                arr1[k++] = right[j++];
            else
            {
                arr1[k++] = left[i++];
                arr1[k++] = right[j++];
            }
        }
        while (i < left.length)
            arr1[k++] = left[i++];
        while (j < right.length)
            arr1[k++] = right[j++];
    }
}
