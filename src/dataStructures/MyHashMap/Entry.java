package dataStructures.MyHashMap;

/**
 * Created by aditya.dalal on 15/11/17.
 */
public class Entry<K,V> {

    private int hashCode;
    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(int hashCode) {
        this.hashCode = hashCode;
    }

    public int getHashCode() {
        return this.hashCode;
    }

    public V getValue() {
        return this.value;
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry<K, V> entry) {
        next = entry;
    }
}
