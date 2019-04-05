import java.util.*;

// We cannot change this

interface Addable<T> { void add(T t); }

interface Generator<T> { T next(); }

/* Fills an addable with a size of new instances of T */
class Filler {
    
    // Classtoken version:
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }
    
    // Generator version:
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}

// We can change this

/* Converts collection to addable */
class AddableCollectionAdapter<T> implements Addable<T> {
    
    private Collection<T> c;
    
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }
    
    public void add(T item) { c.add(item); }
}

/* Returns adapter object for given object for convenience */
class Adapter {
    public static <T> Addable<T> makeAddable(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

/* Simple class visualising fill mechanism results */
class Numbered {
    static int count= 0;
    int no= count++;
    public String toString() { return String.format("%d", no); }
}

public class AdapterTest {

    public static void main(String []args) {
        
        System.out.println("Hello World");
        
        // Creating instance of our type
        List<Numbered> l= new LinkedList<Numbered>();
        
        // Making it addable to be able to be processed by Filler
        Addable<Numbered> a= Adapter.makeAddable(l);
        
        // Process addable by filler
        Filler.fill(a, Numbered.class, 10);
        
        // Check out fill results applied to our type
        System.out.println(l);

    }
}















