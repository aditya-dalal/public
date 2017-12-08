package generics;

import java.util.Iterator;

/**
 * Created by aditya.dalal on 18/03/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Queue<String> genericQueue = new Queue<>(3);

        genericQueue.add("a");
        genericQueue.add("b");
        genericQueue.add("c");
        Iterator<String> queueItr = genericQueue.iterator();
        while (queueItr.hasNext())
            System.out.println(queueItr.next());
        for(String str: genericQueue)
            System.out.println(str);
        System.out.println(genericQueue.poll());
        System.out.println(genericQueue.poll());
        System.out.println(genericQueue.poll());
    }
}
