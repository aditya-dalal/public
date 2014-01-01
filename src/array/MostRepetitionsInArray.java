package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostRepetitionsInArray
{
    public static void main(String[] args)
    {
        int[] arr = {3,4,4,3,5,1,2};
        System.out.println(mostRepetitions(arr));
    }

    private static Set<Integer> mostRepetitions(int[] arr)
    {
        Map<Integer, Integer> repMap = new HashMap<Integer, Integer>();
        Set<Integer> mostRepKeys = new HashSet<Integer>();
        if(arr.length > 0)
        {
            for(int key : arr)
            {
                if(repMap.get(key) == null)
                    repMap.put(key, 1);
                else
                    repMap.put(key, repMap.get(key)+1);
            }

            mostRepKeys.add(arr[0]);
            for(int key : repMap.keySet())
            {
                if(repMap.get(key) > repMap.get(mostRepKeys.iterator().next()))
                {
                    mostRepKeys.clear();
                    mostRepKeys.add(key);
                }
                if(repMap.get(key) == repMap.get(mostRepKeys.iterator().next()))
                    mostRepKeys.add(key);
            }
        }
        return mostRepKeys;
    }
}
