//: innerclasses/Sequence1.java
package ru.grimble.tij4.holding; /* Added by Eclipse.py */
// Holds a sequence of Objects.

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

interface Selector {
  boolean end();
  Object current();
  void next();
}

public class Sequence1 {
  private Object[] items;
  private int next = 0;
  public Sequence1(int size) { items = new Object[size]; }
  public void add(Object x) {
    if(next < items.length)
      items[next++] = x;
  }
  private class SequenceSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == items.length; }
    public Object current() { return items[i]; }
    public void next() { if(i < items.length) i++; }
  }

  private class SequenceIterator implements Iterator {

    private int i= 0;

    @Override
    public boolean hasNext() {
      return i < items.length;
    }

    @Override
    public Object next() {
      return items[i++];
    }

    @Override
    public void remove() {
      LinkedList ll= new LinkedList(Arrays.asList(items));
      ll.remove(--i);
      items= ll.toArray();
    }
  }

  public Selector selector() {
    return new SequenceSelector();
  }	
  public static void main(String[] args) {
    Sequence1 sequence1= new Sequence1(10);
    for(int i = 0; i < 10; i++)
      sequence1.add(Integer.toString(i));
    Selector selector = sequence1.selector();
    while(!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
    System.out.println();

    Iterator it= sequence1.new SequenceIterator();
    while (it.hasNext()) {
      Object o= it.next();
      if (o.equals("4"))
        it.remove();
      else
        System.out.print(o + " ");
    }
    System.out.println();

  }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~






























