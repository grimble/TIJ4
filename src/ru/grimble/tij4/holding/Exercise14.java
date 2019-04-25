package ru.grimble.tij4.holding;

import java.util.LinkedList;
import java.util.ListIterator;

import static net.mindview.util.Print.*;

public class Exercise14 {

    public static void main(String[] args) {

        LinkedList ll= new LinkedList();

        ListIterator it= ll.listIterator();

        it.add(1);
        it.add(2);
        print(ll);

        for (int i= 3; i < 11; i+=2) {
            it.previous();
            it.add(i);
            it.add(i + 1);
            print(ll);
        }

    }

}
