package problems;

import java.util.Arrays;

public class SortArrayByOddEven
{
    static Integer[] arr = {8,6,4,2,7,5,3,1};
    static int positiveIndex = -1;

    public static void main(String[] args)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 == 0 && positiveIndex == -1)
                positiveIndex = i;
            else if(arr[i] % 2 == 1 && positiveIndex != -1)
            {
                pushBeforePositive(arr[i], i);
            }
        }
        System.out.println(Arrays.asList(arr));
    }

    private static void pushBeforePositive(Integer value, int index)
    {
        for(int j = index; j > positiveIndex; j-- )
        {
            arr[j] = arr[j-1];
        }
        arr[positiveIndex] = value;
        positiveIndex++;
    }

}
