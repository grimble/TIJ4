package reusing;

class Base {
    Base(int i) {}
}

class Derived extends Base {
    Derived() {
        super(1);
    }
    Derived(int i) {
        super(i);
    }
}

public class Exersise8 {

}
