package dataStructures.stacks.equalStacks;

import java.util.Scanner;

/**
 * Created by aditya.dalal on 02/10/17.
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        long h1t = 0, h2t = 0, h3t = 0;
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            h1t += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            h2t += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            h3t += h3[h3_i];
        }

        int i = 0, j = 0, k = 0;
        while(true){
            if(h1t == h2t && h2t == h3t)
                break;
            int[] temp;
            long max;
            if(h1t > h2t) {
                max = h1t;
                temp = h1;
            }
            else {
                max = h2t;
                temp = h2;
            }
            if(h3t > max) {
                max = h3t;
                temp = h3;
            }
            if(temp == h1)
                h1t -= h1[i++];
            else if(temp == h2)
                h2t -= h2[j++];
            else
                h3t -= h3[k++];

        }
        System.out.println(h1t);
    }
}
