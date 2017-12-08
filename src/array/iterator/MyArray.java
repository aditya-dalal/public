package array.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aditya.dalal on 16/11/17.
 */
public class MyArray<E> implements Iterable<E> {

    private List<E> arr;

    public MyArray() {
        arr = new ArrayList<>();
    }

    public void add(E val) {
        arr.add(val);
    }

    public Iterator<E> iterator() {
        return new EvenIterator();
    }

    class EvenIterator implements Iterator<E> {

        int index;

        public boolean hasNext() {
            return index < arr.size();
        }

        public E next() {
            E val = arr.get(index);
            index += 2;
            return val;
        }
    }
}
