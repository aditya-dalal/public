package temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aditya.dalal on 17/05/17.
 */
public class Solution {
    static List<Integer> stack = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int lines = Integer.parseInt(in.nextLine());
        for(int i = 0; i < lines; i++) {
            String operation = in.nextLine();
            String[] params = operation.split(" ");
            switch (params[0]) {
                case "push":
                    stack.add(Integer.parseInt(params[1]));
                    printTop();
                    break;
                case "pop":
                    stack.remove(stack.size()-1);
                    printTop();
                    break;
                case "inc":
                    addToBottom(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                    printTop();
                    break;
            }
        }
    }

    private static void addToBottom(int x, int d) {
        for(int i = 0 ;i < x; i++) {
            stack.set(i, stack.get(i) + d);
        }
    }

    public static void printTop() {
        if(stack.size() <= 0)
            System.out.println("EMPTY");
        else
            System.out.println(stack.get(stack.size()-1));
    }
}
