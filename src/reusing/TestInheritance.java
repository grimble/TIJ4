package reusing;

import static net.mindview.util.Print.*;

class Foo {

    static {
        print("Foo init");
    }

    void bar() {
        print("Foo.bar");
    }
}

class Foo1 extends Foo {

    static {
        print("Foo1 init");
    }

    void bar() {
        print("Foo1.bar");
    }

    void superBar() { super.bar(); }
}


public class TestInheritance {
    public static void main(String[] args) {

        Foo1 foo1= new Foo1();
        foo1.bar();
        foo1.superBar();

        Foo foo;

        foo= foo1;
        foo.bar();

        print(foo);
        print(foo1);

    }
}
