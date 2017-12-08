package problems;

/**
 * Created by aditya.dalal on 05/04/17.
 */

// Find sum of all elements.
// + Add two previous values
// * Multiply two previous values
// z replace previous value by 0

public class StringArrayWithOperators {
    public static void main(String[] args) {
//        String arr[] = {"1","2","3","4", "+","2", "*","z", "3", "1", "+"};
        String arr[] = {"+", "+", "*", "2", "+", "*", "3", "+"};
        System.out.println(getCount(arr));
    }

    private static int getCount(String[] arr) {
        int p = -1, pp = -2, sum = 0;
        if(arr.length == 0)
            return 0;
        if (arr.length == 1)
            return isInt(arr[0]) ? Integer.parseInt(arr[0]) : 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("+") && pp >= 0)
                arr[p] = String.valueOf(Integer.parseInt(arr[p]) + Integer.parseInt(arr[pp]));
            else if(arr[i].equals("*") && pp >= 0)
                arr[p] = String.valueOf(Integer.parseInt(arr[p]) * Integer.parseInt(arr[pp]));
            else if(arr[i].equals("z") && pp >= 0)
                arr[p] = "0";
            else if(pp >= 0)
                sum += Integer.parseInt(arr[pp]);
            if(isInt(arr[i])) {
                pp = p;
                p = i;
            }
        }
        if(p >= 0)
            sum += Integer.parseInt(arr[p]);
        if(pp >= 0)
            sum += Integer.parseInt(arr[pp]);
        return sum;
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
