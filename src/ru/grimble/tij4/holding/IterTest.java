package ru.grimble.tij4.holding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import static net.mindview.util.Print.*;

public class IterTest {
    public static void main(String[] args) {

        Random r= new Random();

        r.setSeed(123);

        LinkedList<Integer> ll= new LinkedList<Integer>();

        for (int i=0; i < 10; i++) {
            ll.add(r.nextInt(100));
        }

        print(ll);

        for (Iterator<Integer> it= ll.iterator(); it.hasNext(); ) {
            print(it.next());
        }

    }
}
