package GooglePractice.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomIteratorExample
{
    public static void main(String[] args)
    {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("hi");
        myList.add("hello");
        myList.add("howdy");
        myList.add("wazzup");

        MyList<String> list = new MyList<String>(myList);

        for(String val : list)
            System.out.println(val);

        Iterator<String> itr = list.iterator();

        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println(itr.next());
    }
}
