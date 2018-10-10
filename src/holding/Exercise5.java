package holding;

import java.util.*;

import static net.mindview.util.Print.print;

class Pets {
    
    static Random rand;
    
    static int DIM= 10000;
    
    static void initRand(int seed) {
        rand= new Random(seed);
    }

    static Integer next() { return rand.nextInt(Pets.DIM); }
    
    static List<Integer> arrayList(int len) {

        List<Integer> pets= new ArrayList<Integer>();
        for (int i=0; i < len; i++) {
            pets.add(Pets.next());
        }
        return pets;
    }
}

public class Exercise5 {

    public static void main(String[] args) {

        Pets.initRand(47);

        Random rand = new Random(48);

        // When Integer all comparisons by value
        List<Integer> pets = Pets.arrayList(7);

        print("1: " + pets);

        Integer h = rand.nextInt(Pets.DIM);

        pets.add(h); // Automatically resizes

        print("2: " + pets);
        print("3: " + pets.contains(h));

        pets.remove(h); // Remove by object

        Integer p = pets.get(2);

        print("4: " +  p + " " + pets.indexOf(p));

        Integer cymric = rand.nextInt(Pets.DIM);

        print("5: " + pets.indexOf(cymric));
        print("6: " + pets.remove(cymric));

        // Must be the exact object:
        print("7: " + pets.remove(p));
        print("8: " + pets);

        pets.add(3, rand.nextInt(100)); // Insert at an index

        print("9: " + pets);

        List<Integer> sub = pets.subList(1, 4);

        print("subList: " + sub);
        print("10: " + pets.containsAll(sub));

        Collections.sort(sub); // In-place sort

        print("sorted subList: " + sub);

        // Order is not important in containsAll():
        print("11: " + pets.containsAll(sub));

        Collections.shuffle(sub, rand); // Mix it up

        print("shuffled subList: " + sub);
        print("12: " + pets.containsAll(sub));

        List<Integer> copy = new ArrayList<Integer>(pets);

        sub = Arrays.asList(pets.get(1), pets.get(4));

        print("sub: " + sub);

        copy.retainAll(sub);

        print("13: " + copy);

        copy = new ArrayList<Integer>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index

        print("14: " + copy);

        copy.removeAll(sub); // Only removes exact objects

        print("15: " + copy);

        copy.set(1, rand.nextInt(100)); // Replace an element

        print("16: " + copy);

        copy.addAll(2, sub); // Insert a list in the middle

        print("17: " + copy);
        print("18: " + pets.isEmpty());

        pets.clear(); // Remove all elements

        print("19: " + pets);
        print("20: " + pets.isEmpty());

        pets.addAll(Pets.arrayList(4));

        print("21: " + pets);

        Object[] o = pets.toArray();

        print("22: " + o[3]);

        Integer[] pa = pets.toArray(new Integer[0]);

//        print("23: " + pa[3].id());
    }


}
