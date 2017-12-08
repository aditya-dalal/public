package array;

import java.util.Scanner;

/**
 * Created by aditya.dalal on 15/09/17.
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] vals = input.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = vals.length-1; i >= 0; i--)
            result.append(vals[i]).append(" ");
        System.out.println(result.toString().trim());
    }
}
