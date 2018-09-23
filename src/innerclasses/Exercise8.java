package innerclasses;

import static net.mindview.util.Print.*;

class Outer {

    class Inner {
        private void foo() { print("Outer.Inner foo"); }
    }

    void test() {
        Inner i= new Inner();
        i.foo();
    }
}

public class Exercise8 {
    public static void main(String[] args) {

        print("Accessing private method foo class Outer inner class Inner from outer class method");

        (new Outer()).test();

    }
}
