package array.iterator;

/**
 * Created by aditya.dalal on 16/11/17.
 */
public class Client {
    public static void main(String[] args) {
        MyArray<String> arr = new MyArray<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");

        for (String val: arr)
            System.out.println(val);

        MyArray<Integer> iArr = new MyArray<>();
        iArr.add(0);
        iArr.add(1);
        iArr.add(2);
        iArr.add(3);
        for (int val: iArr)
            System.out.println(val);
    }
}
