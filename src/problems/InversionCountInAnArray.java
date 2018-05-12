package problems;

import java.util.Arrays;

/**
 * Created by aditya.dalal on 06/03/18.
 */
public class InversionCountInAnArray {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,12,8,6,11,4,9,7,10};
        System.out.println(bruteForceInversionCount(arr));
        int[] arr1 = {3,5,1,2,12,8,6,11,4,9,7,10};
        System.out.println(mergeSortInversionCount(arr1, 0, arr.length-1));
        int[] arr2 = {3,5,1,2,12,8,6,11,4,9,7,10};
        System.out.println(mergeSort(arr2, arr.length));
    }

    private static int bruteForceInversionCount(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }

    static int mergeSortInversionCount(int[] arr, int min, int max) {
        int count = 0;
        if(min < max) {
            int mid = (min+max)/2;
            count = mergeSortInversionCount(arr, min, mid);
            count += mergeSortInversionCount(arr, mid+1, max);
            count += merge(arr, min, mid, max);
        }
        return count;
    }

    static int merge(int[] arr, int min, int mid, int max) {
        int[] left = Arrays.copyOfRange(arr, min, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, max+1);
        int i = 0, j = 0, k = min, count = 0;
        while (i < left.length && j < right.length) {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                count += left.length-i;
                arr[k++] = right[j++];
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return count;
    }

    static int mergeSort(int arr[], int array_size)
    {
        int temp[] = new int[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }

    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    static int _mergeSort(int arr[], int temp[], int left, int right)
    {
        int mid, inv_count = 0;
        if (right > left)
        {
        /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left)/2;

        /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
            inv_count  = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid+1, right);

        /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    static int merge(int arr[], int temp[], int left, int mid, int right)
    {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];

         /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

      /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

      /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

      /*Copy back the merged elements to original array*/
        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}
