package generics;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by aditya.dalal on 15/03/17.
 */
public class Queue<T> implements Iterable<T> {
    private T[] arr1;
    private Object[] arr2;
    private T[] arr3;
    private int size;
    private int front;
    private int back;

    public Queue(Class<T> type, int size) {
        arr3 = (T[]) Array.newInstance(type, size);
        this.size = size;
    }

    public Queue(int size) {
        arr1 = (T[]) new Object[size];
        arr2 = new Object[size];
        this.size = size;
    }

    public void add(T val) throws Exception {
        if(back < size)
            arr1[back++] = val;
        else
            throw new Exception("Queue is full");
    }

    public T poll() throws Exception {
        if(front < back)
            return arr1[front++];
        throw new Exception("Queue is empty");
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<T> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                try {
                    throw new Exception("Queue is empty");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arr1[position++];
        }
    }
}
