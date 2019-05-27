package ru.grimble.tij4.io;

import java.io.*;
import java.util.*;

public class Exercise7 {
    
    public interface OutputModifier {
        String modify(String s);
    }


    public static void printReversed(String fileName) throws IOException {
        printReversed(fileName, new OutputModifier() {
            @Override
            public String modify(String s) {
                return s;
            }

            @Override
            public String toString() {
                return "none";
            }
        });

    }

    public static void printReversed(String fileName, OutputModifier m) throws IOException {

        BufferedReader isr= new BufferedReader(new FileReader(fileName));

        String s;
        LinkedList<String> ll= new LinkedList<String>();

        while((s= isr.readLine()) != null)
            ll.addLast(s);

        System.out.format("Contents of %s, reversed, modification %s:\n", fileName, m);


        Collections.sort(ll, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        Iterator<String> it= ll.iterator();

        while(it.hasNext())
            System.out.println(m.modify(it.next()));

    }

    public static void main(String[] args) throws IOException {

        String fileName= "test.txt";

        printReversed(fileName);

    }

}
