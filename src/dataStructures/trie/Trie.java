package dataStructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aditya.dalal on 12/09/17.
 */
public class Trie {
    public static void main(String[] args) {
        String []words = {"there", "their", "answer", "any", "an", "the", "bye", "theist", "a"};
        Node trie = new Node();
        for(String word: words)
            insert(trie, word);
        System.out.println(autoSuggest(trie, "a"));
        System.out.println(search(trie, "answer"));
        delete(trie, "answer", 0);
        System.out.println(autoSuggest(trie, "a"));
        System.out.println(search(trie, "answer"));
    }

    public static void insert(Node root, String word) {
        for (int i = 0 ;i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = root.childern.get(c);
            if (child == null) {
                child = new Node();
                root.childern.put(c, child);
            }
            if(i == word.length()-1)
                child.isEndOfWord = true;
            root = child;
        }
    }

    public static List<String> autoSuggest(Node root, String str) {
        List<String> words = new ArrayList<>();
        Node child;
        for(char c: str.toCharArray()) {
            child = root.childern.get(c);
            if(child == null)
                return words;
            root = child;
        }
        if(root.isEndOfWord)
            words.add(str);
        findWords(words, root, str);
        return words;
    }

    private static void findWords(List<String> words, Node root, String str) {
        if(root.childern.size() == 0)
            return;
        for(Map.Entry<Character, Node> entry: root.childern.entrySet()) {
            char c = entry.getKey();
            Node child = entry.getValue();
            if(child.isEndOfWord)
                words.add(str + c);
            findWords(words, child, str + c);
        }
    }

    private static boolean search(Node root, String word) {
        for(int i = 0; i < word.length(); i++) {
            Node child = root.childern.get(word.charAt(i));
            if(child == null)
                return false;
            root = child;
        }
        if(root.isEndOfWord)
            return true;
        return false;
    }

    public static void delete(Node node, String word, int index) {
        char c = word.charAt(index);
        Node temp = node.childern.get(c);
        if(temp == null)
            return;
        if(index == word.length()-1)
            temp.isEndOfWord = false;
        else
            delete(temp, word, index+1);
        if(temp.childern.size() == 0 && !temp.isEndOfWord)
            node.childern.remove(c);
    }

    public static void delete1(Node root, String word, int charIndex) {
        if(charIndex < word.length()) {
            char c = word.charAt(charIndex);
            Node child = root.childern.get(c);
            if(child == null)
                return;
            delete(child, word, charIndex+1);
            if(charIndex == word.length()-1) {
                if(child.childern.size() == 0)
                    root.childern.remove(c);
                else if(child.isEndOfWord)
                    child.isEndOfWord = false;
            }
            else if(child.childern.size() == 0 && !child.isEndOfWord)
                root.childern.remove(c);
        }

    }

}

class Node {
    Map<Character, Node> childern;
    boolean isEndOfWord;

    public Node() {
        childern = new HashMap<>();
    }
}