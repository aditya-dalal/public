package algorithms;

import java.util.Arrays;

public class InsertionSortDecending
{
    public static void main(String[] args)
    {
        Integer[] arr = {4,6,2,8,5,3,1,9,0,7};
        int value;

        for(int i = 1; i < arr.length; i++)
        {
            value = arr[i];
            int j;
            for(j = i-1; j >= 0; j--)
            {
                if(value > arr[j])
                    arr[j+1] = arr[j];
                else
                    break;
            }
            arr[j+1] = value;
        }
        System.out.println(Arrays.asList(arr));
    }
}
