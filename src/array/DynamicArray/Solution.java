package array.DynamicArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aditya.dalal on 17/09/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] vals = line.split(" ");
        int n = Integer.parseInt(vals[0]);
        int q = Integer.parseInt(vals[1]);
        List<String> queries = new ArrayList<>();
        for(int i = 0; i < q; i++)
            queries.add(scanner.nextLine());
        parseQueries(n, queries);
    }

    private static void parseQueries(int n, List<String> queries) {
        List<List<Integer>> seqs = new ArrayList<>();
        for(int i = 0; i < n; i++)
            seqs.add(new ArrayList<>());
        int lastAnswer = 0;
        for(String query: queries) {
            String[] vals = query.split(" ");
            int seq = (Integer.parseInt(vals[1]) ^ lastAnswer) % n;
            int q = Integer.parseInt(vals[0]);
            if(q == 1) {
                seqs.get(seq).add(Integer.parseInt(vals[2]));
            }
            else {
                int index = Integer.parseInt(vals[2]) % seqs.get(seq).size();
                lastAnswer = seqs.get(seq).get(index);
                System.out.println(lastAnswer);
            }
        }
    }
}
