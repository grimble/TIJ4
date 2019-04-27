package ru.grimble.tij4.containers;

import java.util.*;

import containers.*;

class FastTraversalLinkedList<T> extends AbstractList<T> {

    private LinkedList<T> ll= new LinkedList<T>();
    private ArrayList<T> aa= new ArrayList<T>();

    @Override
    public int size() {
        return aa.size();
    }

    @Override
    public boolean add(T t) {
        ll.add(t);
        aa.add(t);
        return true;
    }

    @Override
    public T remove(int index) {
        ll.remove(index);
        return aa.remove(index);
    }

    @Override
    public T get(int index) {
        return aa.get(index);
    }
}

public class Exercise33 {

    static Random rand = new Random();
    static int reps = 1000;

    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();

    static {
        tests.add(new Test<List<Integer>>("add") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < listSize; j++)
                        list.add(j);
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
    }

    public static void main(String[] args) {

        Tester.fieldWidth = 10;
        Tester.defaultParams= TestParam.array(10, 5000, 100, 5000, 1000, 1000);

        Tester.run(new FastTraversalLinkedList<Integer>(), tests);
        Tester.run(new LinkedList<Integer>(), tests);
        Tester.run(new ArrayList<Integer>(), tests);

    }
} /* Output: (Sample)
 FastTraversalLinkedList
 size       add       get
   10      2116        57
  100       173        71
 1000       691        43
------- LinkedList -------
 size       add       get
   10       156        74
  100        74       150
 1000        46       685
------- ArrayList -------
 size       add       get
   10       214        94
  100        22        86
 1000        26        91
 *///:~
