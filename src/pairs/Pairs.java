package pairs;

import java.util.*;

public class Pairs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int total = Integer.parseInt(line.split(" ")[0]);
        int diff = Integer.parseInt(line.split(" ")[1]);

        line = scanner.nextLine();

        String[] arr = line.split(" ");
        Map<Integer, Boolean> intMap = new TreeMap<Integer, Boolean>();

        for (int i = 0; i < arr.length; i++)
        {
            intMap.put(Integer.parseInt(arr[i]), true);
        }

        int pairs = 0;
        for(Map.Entry<Integer, Boolean> entry : intMap.entrySet())
        {
            if(intMap.containsKey(entry.getKey() + diff))
                pairs++;
        }

        System.out.println(pairs);
    }
}
