package dataStructures;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by aditya.dalal on 10/04/18.
 */
public class ConcurrentMyMap {
    public static void main(String[] args) throws InterruptedException {
        MyMap<String, Integer> map = new MyMap<>();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                map.put(name+i, i);
                System.out.println(name + ": " + map.get(name+i));
            }
        }).start();

        new Thread(() -> {
            for (int i = 100; i < 110; i++) {
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                map.put("a", i);
                System.out.println(name + ": " + map.get("a"));
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + ": " + map.get("a"));
        }
    }
}

class MyMap<K,V> {
    int size;
    int count;
    final double loadFactor = 0.7;
    Entry[] arr;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public MyMap() {
        this.size = 2;
        this.arr = new Entry[size];
    }

    void put(K key, V val) {
        try {
            lock.writeLock().lock();
            if (count / size >= loadFactor)
                rehash();
            long hash = key.hashCode();
            int index = (int) (hash % size);
            if (arr[index] != null) {
                Entry entry = arr[index];
                Entry prev = null;
                while (entry != null) {
                    if (key.equals(entry.getKey())) {
                        entry.setVal(val);
                        return;
                    }
                    prev = entry;
                    entry = entry.next;
                }
                prev.next = new Entry<>(hash, key, val);
            } else
                arr[index] = new Entry<>(hash, key, val);
            count++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void rehash() {
        size *= 2;
        Entry[] e = new Entry[size];
        for (Entry entry : arr) {
            while (entry != null) {
                Entry curr = entry;
                entry = entry.next;
                curr.next = null;
                int index = (int) (curr.getHash() % size);
                if (e[index] == null)
                    e[index] = curr;
                else {
                    Entry temp = e[index];
                    while (temp.next != null)
                        temp = temp.next;
                    temp.next = curr;
                }
            }
        }
        arr = e;
    }

    V get(K key) {
        try {
            lock.readLock().lock();
            long hash = key.hashCode();
            int index = (int) (hash % size);
            if (arr[index] == null)
                return null;
            Entry entry = arr[index];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry != null)
                return (V) entry.getVal();
            return null;
        }finally {
            lock.readLock().unlock();
        }
    }
}

class Entry<K,V>{
    long hash;
    K key;
    V val;
    Entry next;

    public Entry(long hash, K key, V val) {
        this.hash = hash;
        this.key = key;
        this.val = val;
    }

    void setVal(V val) {
        this.val = val;
    }

    V getVal() {
        return this.val;
    }

    K getKey() {
        return this.key;
    }

    long getHash() {
        return this.hash;
    }
}
