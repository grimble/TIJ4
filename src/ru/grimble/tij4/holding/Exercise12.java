package ru.grimble.tij4.holding;

import java.util.*;

public class Exercise12 {

    public static void main(String[] args) {

        List<Integer> list= new LinkedList<Integer>();

        for (int i=0; i < 10; i++)
            list.add(i);

        List<Integer> list1= new LinkedList<Integer>();

        ListIterator<Integer> li= list.listIterator(list.size());

        while (li.hasPrevious())
            list1.add(li.previous());

        System.out.println(list);
        System.out.println(list1);

        li= list.listIterator(3);
        System.out.println(li.nextIndex());
        System.out.println(li.previousIndex());


    }
}
