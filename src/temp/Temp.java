package temp;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Temp {

    public static void main(String[] args) throws IOException, ParserConfigurationException, XPathExpressionException {
//        Character[] letters = {'a', 'b', 'c', 'a'};
//        List<Character> charList = new ArrayList<Character>(Arrays.asList(letters));
//
//        System.out.println(charList);
//        charList.remove((Object) 'a');
//        System.out.println(charList);
//        charList.remove(0);
//        System.out.println(charList);
//        charList.add('b');
//        charList.add('a');
//        System.out.println(charList);
//        charList.removeAll(Arrays.asList('a', 'b'));
//        System.out.println(charList);
//
//        Integer[] queue = new Integer[5];
//        System.out.println(queue.length);

//        Map<String, String> map = new LinkedHashMap<String, String>();
//        map.put("aditya", "dalal");
//        map.put("some", "some");
//        map.put("any", "any");
//
//        for(String key : map.keySet())
//        {
//            System.out.println(map.get(key));
//        }
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        URL url = classLoader.getResource(".");
//        String path = url.toString();
//        String qa = path.substring(0,path.indexOf("public")+6);
//        System.out.println(qa);

//        #####  Reflection Example
//        SomeClass someClass = new SomeClass();
//        someClass.string = "Aditya";
//        Field[] fields = SomeClass.class.getDeclaredFields();
//
//        SomeClass a = new SomeClass();
//        try {
//            System.out.println(SomeClass.class.getDeclaredField("string").get(someClass));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();


//        Integer[] arr = {10, 17, 27, 3, 16, 13, 1, 5, 7, 12, 4, 8, 9, 0};
//        Integer[] arr = {2,5,3,0,2,3,0,3,3,5,0,5,3};
//        Integer[] arr = {6, 5, 3, 1, 8, 7, 2, 4};

//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(Integer.toBinaryString(3 << 29));
//        System.out.println(3 << 29);
//        System.out.println(Integer.MAX_VALUE - 15 + 1);

//        BufferedReader reader = null;
//        InputStreamReader isr = null;
//        Set<String> uniq = new LinkedHashSet<>();
//        try {
//            isr = new InputStreamReader(new FileInputStream("/tmp/testFile.txt"));
//            reader = new BufferedReader(isr);
//            String line;
//            boolean exit = false;
//            while ((line = reader.readLine()) != null) {
//                for (String word : line.split(" ")) {
//                    uniq.add(word);
//                    if (uniq.size() == 5) {
//                        exit = true;
//                        break;
//                    }
//                }
//                if (exit)
//                    break;
//            }
//        } finally {
//            if(reader != null)
//                reader.close();
//            if(isr != null)
//                isr.close();
//        }
//
//        System.out.println(uniq);
        System.out.println(Long.MAX_VALUE);
        int num = 6;
        System.out.println(toBinary(num));
        System.out.println(Integer.toBinaryString(num));
        System.out.println(toInt(110010));
        System.out.println(Integer.toBinaryString(swap(num)));
        System.out.println(Integer.toBinaryString(0x55555555));

        Integer arr[] = {92, 9, 32, 8, 11, 2};
//        System.out.println(largestNum(arr));
        Comparator<Integer> compare = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String ab = String.valueOf(a) + String.valueOf(b);
                String ba = String.valueOf(b) + String.valueOf(a);
                return ba.compareTo(ab);
            }
        };

        Arrays.sort(arr, compare);
        System.out.println(Arrays.asList(arr));
        System.out.println(change("adb", "abcd"));
        System.out.println(minOps("ABD", "BAA"));

        Integer[] arr1 = {4, 3, 5, 4, 2, 5, 5, 3, 3, 2};
        System.out.println(quickSelect(arr, 0, arr.length - 1, 3));

        MyList top = new MyList();
        top.values.add(1);
        MyList l1 = new MyList();
        l1.values.add(2);
        l1.values.add(2);
        MyList l2 = new MyList();
        l2.values.add(3);
        l2.values.add(3);
        top.lists.add(l1);
        l1.lists.add(l2);
        System.out.println(sum(top));

        System.out.println(new Random().nextInt());


        String str = "aditya";
        System.out.println(str.charAt(1));

        DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse("06-07-2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);

//        System.out.println();
//        bfs(a);
//        dfsRec(a);
    }

    static class MyList{
        public List<Integer> values = new ArrayList<>();
        public List<MyList> lists = new ArrayList<>();
    }

    public static int sum(MyList input){
        Map<Integer, List<Integer>> map = new HashMap<>();
        sumByLevel(input, map, 1);
        int multiplier = map.size(), result = 0;
        for(Integer i : map.keySet())
            System.out.println(i + ": " + map.get(i));
        for(int level = 1; level <= map.size(); level++){
            for(int i : map.get(level))
                result += multiplier * i;
            multiplier--;
        }
        return result;
    }

    public static void sumByLevel(MyList input, Map<Integer, List<Integer>> map, int level){
        if(map.get(level) != null)
            map.get(level).addAll(input.values);
        else
            map.put(level, input.values);
        for(MyList temp : input.lists)
            sumByLevel(temp, map, level+1);
    }

    public static int quickSelect(Integer[] arr, int min, int max, int k){
        if(min <= max){
            int mid = partition(arr, min, max);
            if(mid == k-1)
                return arr[mid];
            if(k-1 < mid)
                return quickSelect(arr, min, mid-1, k);
            else
                return quickSelect(arr, mid+1, max, k);
        }
        return Integer.MAX_VALUE;
    }

    public static void countingSort(Integer[] arr){
        int max = 0;
        for(int a: arr)
            if(max < a)
                max = a;
        int[] count = new int[max+1];

        for(int a : arr)
            count[a]++;

        for(int i = 1; i < count.length; i++)
            count[i] = count[i] + count[i-1];

        Integer result[] = new Integer[arr.length];

        for(int a : arr){
            result[count[a]-1] = a;
            count[a]--;
        }
        System.out.println(Arrays.asList(result));
    }


    public static void dutchFlag(Integer[] arr){
        int i = 0, j = 0, n = arr.length-1;
        while(j <= n){
            switch(arr[j]){
                case 0:
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++; j++;
                    break;
                case 1:
                    j++; break;
                case 2:
                    temp = arr[j];
                    arr[j] = arr[n];
                    arr[n] = temp;
                    n--;
                    break;
            }
        }
    }

    public static void quickSort(Integer[] arr, int start, int end){
        if(start < end){
            int mid = partition(arr, start, end);
            quickSort(arr, start, mid-1);
            quickSort(arr, mid+1, end);
        }
    }

    public static int partition(Integer[] arr, int start, int end){
        int pivot = arr[end];
        int i = start, j = end;
        while(i < j){
            if(arr[i] > pivot){
                arr[j] = arr[i];
                arr[i] = arr[j-1];
                arr[j-1] = pivot;
                j--;
            }
            else
                i++;
        }
        return j;
    }

    public static void heapSort(Integer[] arr){
        heapify(arr);
        for(int i = arr.length-1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, 0, i-1);
        }
    }

    public static void heapify(Integer[] arr){
        for(int i = arr.length/2; i >= 0; i--){
            maxHeap(arr, i, arr.length-1);
        }
    }

    public static void maxHeap(Integer[] arr, int index, int length){
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;

        int larger = index;
        if(left <= length && arr[left] > arr[larger])
            larger = left;
        if(right <= length && arr[right] > arr[larger])
            larger = right;
        if(index != larger){
            int temp = arr[index];
            arr[index] = arr[larger];
            arr[larger] = temp;
            maxHeap(arr, larger, length);
        }
    }

    public static void mergeSort(Integer[] arr, int start, int end){
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(Integer[] arr, int start, int mid, int end){
        int[] left = new int[mid-start+1];
        int[] right = new int[end-mid];
        int a = start;
        for(int i = 0; i < left.length; i++)
            left[i] = arr[a++];
        int b = mid+1;
        for(int j = 0; j < right.length; j++)
            right[j] = arr[b++];
        int i = 0, j = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j])
                arr[start++] = left[i++];
            else if(left[i] > right[j])
                arr[start++] = right[j++];
            else{
                arr[start++] = left[i++];
                arr[start++] = right[j++];
            }
        }
        while(i < left.length)
            arr[start++] = left[i++];
        while(j < right.length)
            arr[start++] = right[j++];
    }

    public static void insertion(Integer[] arr){
        for(int i = 1; i < arr.length; i++){
            int val = arr[i], j = i-1;
            for(; j >= 0 && val < arr[j]; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = val;
        }
    }

    public static void selection(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static int maxRepeating(Integer[] arr, int n, int k) {
        for (int i = 0; i < n; i++)
            arr[arr[i] % k] += k;

        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = i;
            }
        }

    /* Uncomment this code to get the original array back
       for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */

        // Return index of the maximum element
        return result;
    }

    public static int minOps(String s1, String s2){
        if(s1.length() != s2.length())
            return -1;
        int[] count = new int[265];
        for(char c : s1.toCharArray())
            count[c]++;
        for(char c : s2.toCharArray())
            count[c]--;
        for(int i : count)
            if(i > 0)
                return -1;
        int res = 0;
        for(int i = s1.length()-1, j = s1.length()-1; i >= 0; ){
            if(s1.charAt(i) == s2.charAt(j)){
                i--; j--;
                continue;
            }
            while (i >= 0 && s1.charAt(i) != s2.charAt(j)){
                i--;
                res++;
            }
        }
        return res;
    }

    public static boolean change(String s1, String s2){
        if(s1.equals(s2))
            return false;
        if(Math.abs(s1.length()-s2.length()) > 1)
            return false;
        int diff = 0;
        if(s1.length() == s2.length()){
            int i = 0;
            while(i < s1.length() && diff < 2){
                if(s1.charAt(i) != s2.charAt(i))
                    diff++;
                i++;
            }
        }

        if(s1.length() > s2.length()){
            int i = 0, j = 0;
            for(; i < s2.length() && diff < 2; i++, j++){
                if(s1.charAt(i) != s2.charAt(j)){
                    diff++;
                    i++;
                }
            }
            if(i == j)
                diff++;
        }

        if(s1.length() < s2.length()){
            int i = 0, j = 0;
            for(; i < s1.length() && diff < 2; i++, j++){
                if(s1.charAt(i) != s2.charAt(j)){
                    diff++;
                    j++;
                }
            }
            if(i == j)
                diff++;
        }

        return diff == 1;
    }

    public static String largestNum(Integer[] arr){
        Comparator<Integer> lexInt = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                int xy = Integer.valueOf(x.toString()+y.toString());
                int yx = Integer.valueOf(y.toString()+x.toString());
                if(xy > yx)
                    return -1;
                if(xy < yx)
                    return 1;
                return 0;
            }
        };
        System.out.println(Arrays.asList(arr));
        Arrays.sort(arr, lexInt);
        System.out.println(Arrays.asList(arr));
        StringBuilder str = new StringBuilder();
        for (int a : arr)
            str.append(a);
        return str.toString();
    }

    public static void dfsRec(Node root){
        root.visited = true;
        System.out.println(root.value);
        for (Node temp: root.nodes)
            if(!temp.visited)
                dfsRec(temp);
    }

    public static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            System.out.println(n.value);
            for(Node temp: n.nodes)
                if(!temp.visited)
                    queue.add(temp);
            n.visited = true;
        }
    }

    public static void dfs(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node n = stack.pop();
            System.out.println(n.value);
            for(Node temp : n.nodes){
                if(!temp.visited)
                    stack.push(temp);
            }
            n.visited = true;
        }
    }

    static class Node{
        public char value;
        public List<Node> nodes;
        public boolean visited;

        public Node(char value){
            this.value = value;
            nodes = new ArrayList<>();
        }
    }

    public static int swap(int x){
        int val = x & 0xaaaaaaaa;
        System.out.println(Integer.toBinaryString(val));
        val >>= 1;
        System.out.println(Integer.toBinaryString(val));
        int val1 = x & 0x55555555;
        System.out.println(Integer.toBinaryString(val1));
        val1 <<= 1;
        System.out.println(Integer.toBinaryString(val1));
        return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
    }

    public static int toBinary(int num){
        int multiplier = 0;
        int result = 0;
        while(num > 0){
            int val = num%2;
            num /= 2;
            result += val * Math.pow(10, multiplier++);
        }
        return result;
    }

    public static int toInt(int num){
        int pow = 0;
        int res = 0;
        while (num > 0){
            int val = num % 10;
            num = num/10;
            res += val * Math.pow(2, pow++);
        }
        return res;
    }

    private static String reverse(String str) {
        if(str.length() == 1)
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    private static String reverse1(String str) {
        StringBuilder value = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--)
            value.append(str.charAt(i));
        return value.toString();
    }

}