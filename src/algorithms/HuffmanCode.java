package algorithms;

import java.util.ArrayList;
import java.util.List;

public class HuffmanCode
{
    public static void main(String[] args)
    {
        List<Character> charSet = new ArrayList<Character>();
        charSet.add(new Character('a', 45));
        charSet.add(new Character('b', 13));
        charSet.add(new Character('c', 12));
        charSet.add(new Character('d', 16));
        charSet.add(new Character('e', 9));
        charSet.add(new Character('f', 5));

        Character huffmanTree = generateHuffmanTree(charSet);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        printCodesForEachCharacter(huffmanTree, arrayList);
    }

    private static void printCodesForEachCharacter(Character root, ArrayList<Integer> arrayList)
    {
        if(root == null)
            return;

        if(root.left != null)
        {
            arrayList.add(0);
            printCodesForEachCharacter(root.left, arrayList);
        }
        if(root.right != null)
        {
            arrayList.add(1);
            printCodesForEachCharacter(root.right, arrayList);
        }
        else
        {
            System.out.print(root.alphabet + " : ");
            for (int val : arrayList)
                System.out.print(val);
            System.out.println();
        }
        if(arrayList.size() > 0)
            arrayList.remove(arrayList.size()-1);
    }

    private static Character generateHuffmanTree(List<Character> charSet)
    {
        int length = charSet.size();
        List<Character> minPriorityQueue = new ArrayList<Character>(charSet);

        for(int i = 0; i < length-1; i++)
        {
            heapify(minPriorityQueue);
            Character character = new Character();
            character.left = minPriorityQueue.get(0);
            minPriorityQueue.remove(0);
            heapify(minPriorityQueue);
            character.right = minPriorityQueue.get(0);
            minPriorityQueue.remove(0);
            character.frequency = character.left.frequency + character.right.frequency;
            minPriorityQueue.add(character);
        }
        return minPriorityQueue.get(0);
    }

    private static void heapify(List<Character> charSet)
    {
        for(int index = (charSet.size() - 1)/2; index >= 0; index--)
            minHeapify(charSet, index);
    }

    private static void minHeapify(List<Character> charSet, int index)
    {
        int length = charSet.size() - 1;
        int leftIndex = index * 2;
        int rightIndex = index * 2 + 1;
        int smallest = index;

        if(leftIndex <= length &&  charSet.get(leftIndex).frequency < charSet.get(smallest).frequency)
            smallest = leftIndex;
        if(rightIndex <= length && charSet.get(rightIndex).frequency < charSet.get(smallest).frequency)
            smallest = rightIndex;
        if(smallest != index)
        {
            Character temp = charSet.get(index);
            charSet.set(index, charSet.get(smallest));
            charSet.set(smallest, temp);
            minHeapify(charSet, smallest);
        }
    }
}

class Character
{
    char alphabet;
    int frequency;
    Character left;
    Character right;

    public Character() {}

    public Character(char character, int frequency)
    {
        alphabet = character;
        this.frequency = frequency;
    }
}