package holding;

import java.util.*;

import static net.mindview.util.Print.print;

class StringPets {

    static int LENGTH= 7;

    static Random rand;

    static void initRand(int seed) {
        rand= new Random(seed);
    }

    static String next() {
        StringBuffer sb= new StringBuffer();
        for (int j = 0; j < LENGTH; j++)
            sb.append((char) ((int)'A' + rand.nextInt((int)'Z' - (int)'A' + 1)));
        return sb.toString();
    }

    static List<String> arrayList(int len) {

        List<String> pets= new ArrayList<String>();
        for (int i=0; i < len; i++)
            pets.add(next());

        return pets;

    }
}

public class Exercise6 {

    public static void main(String[] args) {

        StringPets.initRand(47);

        Random rand = new Random(47);

        // When Integer all comparisons by value
        List<String> pets = StringPets.arrayList(7);

        print("1: " + pets);

        String h = StringPets.next();

        pets.add(h); // Automatically resizes

        print("2: " + pets);
        print("3: " + pets.contains(h));

        pets.remove(h); // Remove by object

        String p = pets.get(2);

        print("4: " +  p + " " + pets.indexOf(p));

        String cymric = StringPets.next();

        print("5: " + pets.indexOf(cymric));
        print("6: " + pets.remove(cymric));

        // Must be the exact object:
        print("7: " + pets.remove(p));
        print("8: " + pets);

        pets.add(3, StringPets.next()); // Insert at an index

        print("9: " + pets);

        List<String> sub = pets.subList(1, 4);

        print("subList: " + sub);
        print("10: " + pets.containsAll(sub));

        Collections.sort(sub); // In-place sort

        print("sorted subList: " + sub);

        // Order is not important in containsAll():
        print("11: " + pets.containsAll(sub));

        Collections.shuffle(sub, rand); // Mix it up

        print("shuffled subList: " + sub);
        print("12: " + pets.containsAll(sub));

        List<String> copy = new ArrayList<String>(pets);

        sub = Arrays.asList(pets.get(1), pets.get(4));

        print("sub: " + sub);

        copy.retainAll(sub);

        print("13: " + copy);

        copy = new ArrayList<String>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index

        print("14: " + copy);

        copy.removeAll(sub); // Only removes exact objects

        print("15: " + copy);

        copy.set(1, StringPets.next()); // Replace an element

        print("16: " + copy);

        copy.addAll(2, sub); // Insert a list in the middle

        print("17: " + copy);
        print("18: " + pets.isEmpty());

        pets.clear(); // Remove all elements

        print("19: " + pets);
        print("20: " + pets.isEmpty());

        pets.addAll(StringPets.arrayList(4));

        print("21: " + pets);

        Object[] o = pets.toArray();

        print("22: " + o[3]);

//        String[] pa = pets.toArray(new Integer[0]);
//        print("23: " + pa[3].id());
    }


}
