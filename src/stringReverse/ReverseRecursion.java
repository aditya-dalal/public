package stringReverse;

import java.util.Scanner;

public class ReverseRecursion
{
//    static String reversedString = "";

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        System.out.println(reverse(value));
    }

//    static String reverse(String str)
//    {
//        if(str.length() == 1)
//            reversedString += str;
//        else
//        {
//            reversedString += str.charAt(str.length() - 1);
//            reverse(str.substring(0, str.length() - 1));
//        }
//        return reversedString;
//    }

    static String reverse(String str)
    {
        if(str.length() == 1)
            return str;
        else
        {
            return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
        }
    }
}

