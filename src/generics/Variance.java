import java.util.*;

class Fruit {}
class Apple extends Fruit {}
class Grenny extends Apple {}

public class Variance {
    
    static <T> void add(List<? super T> list, T item) { 
        System.out.format("Item %s added to list %s\n", item, list);
        list.add(item); 
    }
    
    static <T> T get(List<? extends T> list, int index) { 
        T item= list.get(index);
        System.out.format("Item %s got from list %s\n", item, list);
        return item; 
    }

    public static void main(String []args) {

        List<Apple> list= new ArrayList<Apple>();
        
        add(list, new Grenny()); // list of something super to Grenny
        
        Fruit f= get(list, 0); // list of something extending Fruit 
        
    }
}
