package problems;

import java.util.Arrays;

public class SortArrayByOddEven
{
    static Integer[] arr = {4,6,1,3,8,2};
    static int positiveIndex = -1;

    public static void main(String[] args)
    {
        sortArrayByOddEven(arr);

//        for(int i = 0; i < arr.length; i++)
//        {
//            if(arr[i] % 2 == 0 && positiveIndex == -1)
//                positiveIndex = i;
//            else if(arr[i] % 2 == 1 && positiveIndex != -1)
//            {
//                pushBeforePositive(arr[i], i);
//            }
//        }
//        System.out.println(Arrays.asList(arr));
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

    private static void sortArrayByOddEven(Integer[] arr) {
        int lo = 0, hi = arr.length - 1, index = 0, temp;

        while (index < hi) {
            temp = arr[index];
            if(arr[index] % 2 == 0) {
                arr[index] = arr[hi];
                arr[hi] = temp;
                hi--;
            }
            else {
                arr[index] = arr[lo];
                arr[lo] = temp;
                lo++;
                index++;
            }
        }

        System.out.println(Arrays.asList(arr));
    }

}
