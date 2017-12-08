package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aditya.dalal on 25/10/17.
 */
public class XYPlaneBarrier {

    public static void main(String[] args) {
        List<Barrier> barriers = new ArrayList<>();
        barriers.add(new Barrier(3,6,2));
        barriers.add(new Barrier(-7,4,3));
//        barriers.add(new Barrier(8, 10, 1));
//        barriers.add(new Barrier(15, 16, 1));
//        barriers.add(new Barrier(1, 2, 1));
//        barriers.add(new Barrier(10, 11, 15));

        Collections.sort(barriers);
        Barrier prev = barriers.get(0);
        int count = prev.x2 - prev.x1 + 1;
        for (int i = 1; i < barriers.size(); i++) {
            Barrier curr = barriers.get(i);
            if(curr.x1 > prev.x2)
                count += curr.x2 - curr.x1 + 1;
            else if(curr.x1 <= prev.x2)
                count += curr.x2 - prev.x2;
            prev = curr;
        }
        System.out.println(count);
    }
}

class Barrier implements Comparable<Barrier>{
    int x1;
    int x2;
    int y;

    public Barrier(int x1, int x2, int y) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

    @Override
    public int compareTo(Barrier o) {
        if(this.x1 < o.x1)
            return -1;
        if(this.x1 > o.x1)
            return 1;
        return 0;
    }
}

class BarrierComparator implements Comparator<Barrier> {
    public int compare(Barrier b1, Barrier b2) {
        if(b1.x1 < b2.x1)
            return -1;
        if(b1.x1 > b2.x1)
            return 1;
        return 0;
    }
}