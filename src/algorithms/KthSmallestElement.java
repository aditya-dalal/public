package algorithms;

public class KthSmallestElement
{
    public static void main(String[] args)
    {
        Integer[] arr = {17,27,3,16,13,10,1,5,7,12,4,8,9,0};

        quickSelect(arr, 0, arr.length-1, 7);
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
            else if(k < mid)
                quickSelect(arr, min, mid - 1, k);
            else
                quickSelect(arr, mid + 1, max, k);
        }
    }

    private static int partition(Integer[] arr, int min, int max)
    {
        int pivot = arr[max];
        int index = min-1, temp;
        for(int i = min; i < arr.length-1; i++)
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
}
