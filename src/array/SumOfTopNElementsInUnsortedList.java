package array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by aditya.dalal on 20/09/17.
 */
public class SumOfTopNElementsInUnsortedList {
    public static void main(String[] args) {
        Integer[] arr = {3,5,1,2,12,8,6,11,4,9,7,10};
        int n = 3;
        System.out.println(sumUsingQuickSelect(arr, n));
        System.out.println(Arrays.asList(arr));
        Integer[] arr1 = {3,5,1,2,12,8,6,11,4,9,7,10};
        System.out.println(sumUsingMaxHeap(arr1, n));
        System.out.println(Arrays.asList(arr1));
    }

    private static int sumUsingMaxHeap(Integer[] arr, int n) {
        heapify(arr);
        int total = 0;
        for (int i = arr.length-1, j = 0; j < n; i--, j++) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            total += temp;
            maxHeap(arr, 0, i-1);
        }
        return total;
    }

    private static void heapify(Integer[] arr) {
        for (int i = (arr.length)/2; i >= 0; i--)
            maxHeap(arr, i, arr.length-1);
    }

    private static void maxHeap(Integer[] arr, int index, int length) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int larger = index;
        if(left <= length && arr[left] > arr[larger])
            larger = left;
        if(right <= length && arr[right] > arr[larger])
            larger = right;
        if(larger != index) {
            int temp = arr[index];
            arr[index] = arr[larger];
            arr[larger] = temp;
            maxHeap(arr, larger, length);
        }
    }

    private static int sumUsingQuickSelect(Integer[] arr, int n) {
        int k = quickSelect(arr, arr.length-n);
        int sum = 0;
        for(int i = k; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    private static int quickSelect(Integer[] arr, int k) {
        int mid = partition(arr, 0, arr.length-1);
        while (mid != k) {
            if(mid < k)
                mid = partition(arr, mid+1, arr.length-1);
            else
                mid = partition(arr, 0, mid);
        }
        return k;
    }

    private static int partition(Integer[] arr, int min, int max) {
        int pivot = getRandomIndex(min, max);
        int temp = arr[pivot];
        arr[pivot] = arr[max];
        arr[max] = temp;

        int pivotValue = arr[max];
        int index = min-1;
        for (int i = min; i < max; i++) {
            if(arr[i] <= pivotValue) {
                ++index;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        ++index;
        arr[max] = arr[index];
        arr[index] = pivotValue;
        return index;
    }

    private static int getRandomIndex(int min, int max) {
        return new Random().nextInt(max-min+1) + min;
    }

}
