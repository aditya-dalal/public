package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by aditya.dalal on 04/05/16.
 */
public class MedianIncreasingArray {
    static List<Integer> arr = new ArrayList<>();
    static Heap minHeap = new Heap(Heap.Type.MIN);
    static Heap maxHeap = new Heap(Heap.Type.MAX);

    public static void main(String[] args){
        for(int i = 0; i < 24; i++){
            insert(new Random().nextInt(1000));
            int median = 0;
            if(maxHeap.size() > minHeap.size())
                median = maxHeap.get(0);
            else if(maxHeap.size() < minHeap.size())
                median = minHeap.get(0);
            else
                median = (maxHeap.get(0) + minHeap.get(0))/2;
            System.out.println("Median: " + median);
        }
        Collections.sort(arr);
        System.out.println(arr);
        maxHeap.print();
        minHeap.print();
    }

    public static void insert(int num){
        arr.add(num);
        if(minHeap.size() == 0){
            minHeap.add(num);
        }
        else if(maxHeap.size() == 0) {
            if(num > minHeap.get(0)) {
                maxHeap.add(minHeap.pop());
                minHeap.add(num);
            }
            else
                maxHeap.add(num);
        }
        else if(num > minHeap.get(0) && num > maxHeap.get(0)){
            if(minHeap.size() > maxHeap.size()){
                int temp = minHeap.pop();
                maxHeap.add(temp);
            }
            minHeap.add(num);
        }
        else if(num < minHeap.get(0) && num < maxHeap.get(0)){
            if(maxHeap.size() > minHeap.size()){
                int temp = maxHeap.pop();
                minHeap.add(temp);
            }
            maxHeap.add(num);
        }
        else {
            if(maxHeap.size() > minHeap.size()){
                int temp = maxHeap.pop();
                minHeap.add(temp);
            }
            maxHeap.add(num);
        }
    }


    static class Heap{
        List<Integer> heap;
        Type type;
        public enum Type{
            MIN, MAX
        }

        public Heap(Type type){
            this.type = type;
            heap = new ArrayList<>();
        }

        public void print(){
            for (int val : heap)
                System.out.print(val + ", ");
            System.out.println();
        }

        public int size(){
            return heap.size();
        }

        public void add(int num){
            heap.add(num);
            if(type == Type.MIN)
                addMinHeapify(heap.size()-1);
            else
                addMaxHeapify(heap.size()-1);

        }

        public int get(int index){
            return heap.get(index);
        }

        public int pop(){
            int val = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size()-1);
            if(heap.size() != 0) {
                if(type == Type.MIN)
                    removeMinHeapify(0);
                else
                    removeMaxHeapify(0);
            }
            return val;
        }

        private void addMinHeapify(int index){
            int parent = (index-1)/2;
            if(parent >= 0 && heap.get(index) < heap.get(parent)){
                int temp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, temp);
                addMinHeapify(parent);
            }
        }

        private void addMaxHeapify(int index){
            int parent = (index-1)/2;
            if(parent >= 0 && heap.get(index) > heap.get(parent)){
                int temp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, temp);
                addMaxHeapify(parent);
            }
        }

        public void removeMinHeapify(int i){
            int left = i*2+1;
            int right = i*2+2;
            int smaller = i;
            if(left <= heap.size()-1 && heap.get(left) < heap.get(smaller))
                smaller = left;
            if(right <= heap.size()-1 && heap.get(right) < heap.get(smaller))
                smaller = right;
            if(smaller != i){
                int temp = heap.get(i);
                heap.set(i, heap.get(smaller));
                heap.set(smaller, temp);
                removeMinHeapify(smaller);
            }
        }

        public void removeMaxHeapify(int i){
            int left = i*2+1;
            int right = i*2+2;
            int larger = i;
            if(left <= heap.size()-1 && heap.get(left) > heap.get(larger))
                larger = left;
            if(right <= heap.size()-1 && heap.get(right) > heap.get(larger))
                larger = right;
            if(larger != i){
                int temp = heap.get(i);
                heap.set(i, heap.get(larger));
                heap.set(larger, temp);
                removeMaxHeapify(larger);
            }
        }
    }

}

