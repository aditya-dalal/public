package dataStructures.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aditya.dalal on 03/10/17.
 */
public class RunningMedian {
    public static void main(String args[] ) throws Exception {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int val = in.nextInt();
            if(min.size() != 0 && val > min.get(0)) {
                min.add(val);
                pushUpMin(min, min.size()-1);
            }
            else {
                max.add(val);
                pushUpMax(max, max.size()-1);
            }
            while (min.size() > max.size()+1) {
                int temp = min.get(0);
                min.set(0, min.remove(min.size()-1));
                pushDownMin(min, 0, min.size()-1);
                max.add(temp);
                pushUpMax(max, max.size()-1);
            }
            while (max.size() > min.size()+1) {
                int temp = max.get(0);
                max.set(0, max.remove(max.size()-1));
                pushDownMax(max, 0, max.size()-1);
                min.add(temp);
                pushUpMin(min, min.size()-1);
            }
            if(min.size() > max.size())
                System.out.printf("%.1f\n", (double) min.get(0));
            else if (max.size() > min.size())
                System.out.printf("%.1f\n", (double) max.get(0));
            else
                System.out.printf("%.1f\n", (double)(min.get(0) + max.get(0))/2);
        }
    }

    static void pushUpMin(List<Integer> list, int index) {
        int parent = (index-1)/2;
        if(parent >= 0 && list.get(parent) > list.get(index)) {
            int temp = list.get(parent);
            list.set(parent, list.get(index));
            list.set(index, temp);
            pushUpMin(list, parent);
        }
    }

    static void pushUpMax(List<Integer> list, int index) {
        int parent = (index-1)/2;
        if(parent >= 0 && list.get(parent) < list.get(index)) {
            int temp = list.get(parent);
            list.set(parent, list.get(index));
            list.set(index, temp);
            pushUpMax(list, parent);
        }
    }

    static void pushDownMin(List<Integer> list, int index, int length) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smaller = index;
        if(left <= length && list.get(left) < list.get(smaller))
            smaller = left;
        if(right <= length && list.get(right) < list.get(smaller))
            smaller = right;
        if(smaller != index) {
            int temp = list.get(index);
            list.set(index, list.get(smaller));
            list.set(smaller, temp);
            pushDownMin(list, smaller, length);
        }
    }

    static void pushDownMax(List<Integer> list, int index, int length) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int larger = index;
        if(left <= length && list.get(left) > list.get(larger))
            larger = left;
        if(right <= length && list.get(right) > list.get(larger))
            larger = right;
        if(larger != index) {
            int temp = list.get(index);
            list.set(index, list.get(larger));
            list.set(larger, temp);
            pushDownMax(list, larger, length);
        }
    }
}
