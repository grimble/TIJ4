package innerclasses;

import org.jetbrains.annotations.NotNull;

import static net.mindview.util.Print.*;

interface WithNestedStatic {
    void foo();
    void bar();
    class Test {
        public static void testFoo(@NotNull WithNestedStatic wns) { wns.foo(); }
        public static void testBar(@NotNull WithNestedStatic wns) { wns.bar(); }
    }
}

class WithNestedStaticImpl implements WithNestedStatic {
    @Override
    public void foo() {
        print("foo");
    }

    @Override
    public void bar() {
        print("bar");
    }
}

public class Exercise21 {

    public static void main(String[] args) {

        WithNestedStaticImpl wnsi= new WithNestedStaticImpl();

        WithNestedStatic.Test.testFoo(wnsi);
        WithNestedStatic.Test.testBar(wnsi);

    }


}
