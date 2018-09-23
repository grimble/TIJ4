package holding;

import java.util.*;

import static net.mindview.util.Print.*;

class NameGenerator {

    static String[] names= {"Homer", "March", "Bart", "Lisa", "Maggie"};

    static final int TEST_LENGTH= 6;

    static String[] newStringsArray() { return new String[TEST_LENGTH]; }

    int index;

    String next() {
        if (index == names.length)
            index= 0;
        return names[index++];
    }

    /**
     * Fills array of strings without calling other methods.
     * @param sa Array of strings to be filled in
     * @return Array of strings passed in parameter
     */
    String[] fillStringDirectly(String[] sa) {
        for (int i=0; i < sa.length; i++)
            sa[i]= next();
        return sa;
    }

    /**
     * Adaptor class used to fill array of strings via collection filling method.
     */
    class StringsArray2FillAdaptor extends ArrayList<String> {

        String[] data;

        StringsArray2FillAdaptor(String[] data) {
            this.data= data;
        }

        String[] getStringsArray() {
            for (int i=0; i < TEST_LENGTH; i++) {
                data[i]= get(i);
            }
            return data;
        }

    }

    /**
     * Fills array of string via collection fill transforming it to adaptor class.
     * @param sa Array of strings to be filled in
     * @return Array of strings passed in parameter
     */
    String[] fill(final String[] sa) {

        return ((StringsArray2FillAdaptor)fill((new StringsArray2FillAdaptor(sa) {

        }))).getStringsArray();
    }

    Collection<String> fill(Collection<String> c) {
        for (int i=0; i < TEST_LENGTH; i++)
            c.add(next());
        return c;
    }

}

public class Exercise4 {

    public static void test(String[] args) {

        NameGenerator ng= new NameGenerator();

        print(ng.fill(NameGenerator.newStringsArray()));
        print(ng.fill(new ArrayList<String>()));
        print(ng.fill(new LinkedList<String>()));
        print(ng.fill(new HashSet<String>()));
        print(ng.fill(new LinkedHashSet<String>()));

    }

    static void printArray(Object[] a) {
        for (Object o : a)
            print(o);
        print("---");
    }

    public static void main(String[] args) {

        NameGenerator ng= new NameGenerator();

        String[] sa= NameGenerator.newStringsArray();

        printArray(sa);

        printArray(ng.fill(sa));

        NameGenerator.StringsArray2FillAdaptor saa= ng.new StringsArray2FillAdaptor(sa);

        ng.fill(saa);

        printArray(saa.getStringsArray());

        print(sa);

        print(saa.getStringsArray());

    }
}
