package dataStructures.MyHashMap;

import java.util.List;

/**
 * Created by aditya.dalal on 15/11/17.
 */
public class MyHashMap<K, V> {

    private int size;
    private final double loadFactor = 0.7;
    private int count;
    private Entry[] map;

    public MyHashMap() {
        size = 5;
        map = new Entry[size];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        Entry entry = map[getIndex(hash)];
        if(entry != null) {
            Entry prev = null;
            do {
                if(key.equals(entry.getKey())) {
                    entry.setValue(value);
                    return;
                }
                prev = entry;
                entry = entry.getNext();
            } while (entry != null);
            prev.setNext(getEntry(key, value, hash));
            return;
        }
        if(count/(double)size > loadFactor)
            rehash();
        map[getIndex(hash)] = getEntry(key, value, hash);
        count++;
    }

    private Entry getEntry(K key, V value, int hash) {
        Entry e = new Entry(hash);
        e.setKey(key);
        e.setValue(value);
        return e;
    }

    private int getIndex(int hash) {
        return hash % size;
    }

    private void rehash() {
        count = 0;
        size *= 2;
        Entry[] newMap = new Entry[size];
        for(Entry entry: map) {
            if(entry == null)
                continue;
            int hash = entry.getKey().hashCode();
            int index = getIndex(hash);
            newMap[index] = entry;
            count++;
        }
        map = newMap;
    }

    public V get(K key) {
        int hash = key.hashCode();
        Entry entry = map[getIndex(hash)];
        if(entry == null)
            return null;
        else {
            do {
                if(key.equals(entry.getKey()))
                    return (V) entry.getValue();
                entry = entry.getNext();
            } while (entry != null);
        }
        return null;
    }
}
