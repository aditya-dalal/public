package temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by aditya.dalal on 06/08/16.
 */
public class Temp1 {

    public static void main(String[] args) {
        String s1 = "SvUceDR5u7q5/E/pdfcAlw1mLmV/UwBfe1ENnWbvLQufLEgF9UgIm4uNc1Karud0amOyxIxUCpfxxlUpu3OnKCZVlMP1U+x2Pat6JrfORTJ7RCi/rL12/BvqvnLr5v5tKrBkhBpYmfrnjaLggyk0jZl2Ol4//A+DTX2ESGFk65bmnsxEPkY1q2PTbqgbjgE7/8Jf2QMLieayIyqy8F+kvq0ZsjOtp12ZH7+w9pL7OSbveFerqzcrBiIDn8zcCTHoat8LCv2sRUVIAZnFBfXofmXePbTU+jfCTu+HUtzkjeovlQGkkZQGawlHKOdmWHqX8ZkSLm+m1GO2V1tRSGIQbA==";
        String s2 = "MUswGAYJKoZIhvcNAQkDMQsGCSqGSIb3DQEHATAvBgkqhkiG9w0BCQQxIgQgO5aB0dtXQg6K/g24DkrNxDSwR7mh+qK+FvL3ik5jDlk=";
        String s3 = "SvUceDR5u7q5/E/pdfcAlw1mLmV/UwBfe1ENnWbvLQufLEgF9UgIm4uNc1Karud0amOyxIxUCpfxxlUpu3OnKCZVlMP1U+x2Pat6JrfORTJ7RCi/rL12/BvqvnLr5v5tKrBkhBpYmfrnjaLggyk0jZl2Ol4//A+DTX2ESGFk65bmnsxEPkY1q2PTbqgbjgE7/8Jf2QMLieayIyqy8F+kvq0ZsjOtp12ZH7+w9pL7OSbveFerqzcrBiIDn8zcCTHoat8LCv2sRUVIAZnFBfXofmXePbTU+jfCTu+HUtzkjeovlQGkkZQGawlHKOdmWHqX8ZkSLm+m1GO2V1tRSGIQbA==";

        byte[] decoded = Base64.getDecoder().decode(s2);
        try {
            System.out.println(s1.equals(s3));
            FileOutputStream fos = new FileOutputStream("/Users/aditya.dalal/rsa_keys/sign_verify/decoded.txt");
            fos.write(decoded);
            fos.close();
            Path path = Paths.get("/Users/aditya.dalal/rsa_keys/sign_verify/decoded.txt.sign");
            byte[] data = Files.readAllBytes(path);
            System.out.println(Base64.getEncoder().encodeToString(data));
            for(int i =0; i < decoded.length; i++) {
                if(decoded[i] != data[i]) {
                    System.out.println("Failed");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(s3.length());
//        System.out.println(s1.equals(s2));
    }



    public static void swapByPairs(Node root) {
        Node n1, n2;
        while (root != null && root.next != null) {
            n1 = root;
            n2 = root.next;
            root = root.next.next;
            swap(n1, n2);
        }
    }

    public static void printRev(Node root) {
        while (root != null) {
            System.out.print(root.value + " -> ");
            root = root.prev;
        }
        System.out.println();
    }

    public static void print(Node root) {
        while (root != null) {
            System.out.print(root.value + " -> ");
            root = root.next;
        }
        System.out.println();
    }

    public static void swap(Node n1, Node n2) {
        n1.next = n2.next;
        if(n2.next != null)
            n2.next.prev = n1;
        if(n1.prev != null)
            n1.prev.next = n2;
        n2.next = n1;
        n2.prev = n1.prev;
        n1.prev = n2;
    }

    static class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

