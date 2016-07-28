package crackingCodingInterview.arraysAndStrings;

/**
 * Created by aditya.dalal on 05/05/16.
 */
public class SplitArrayOnEqualLeftZerosRightOnes {
//    {}
//    {1}
//    {0}
//    {1,1,0,0}
//    {0,0,1,1}
//    {0,1,1,0}
//    {1,0,0,1}
//    {1,0,1}
//    {0,1,0}
//    {1,0,1,0}

    public static void main(String [] args) {
        int[] arr1 = {0,1,0,1,1,1,0,0,1,0,1,0,1,0,1,1,0,0};
        System.out.println(weightMid(arr1));
    }

    public static int weightMid(int[] arr){
        if(arr.length == 0)
            return -1;
        int zeros = 0, ones = 0, index = -1;
        for(int i = 0, j = arr.length-1; i<j;){
            if(arr[i] != 0){
                if(zeros > 0)
                    index = i;
                i++;
                continue;
            }
            if(arr[j] != 1){
                j--;
                continue;
            }
            zeros++; ones++; index = i; i++; j--;
            if(i == j && arr[i] == 1)
                index = i;
        }
        return index;
    }
}
