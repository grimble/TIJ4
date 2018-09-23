package interfaces;

abstract class Base {
    abstract void print();
    public Base() { print(); }
}

class Derived extends Base {
    int i= 8;
    void print() {
        System.out.println(i);
    }
}

public class Exercise3 {
    public static void main(String[] args) {

        Derived d= new Derived();

        d.print();
    }
}
