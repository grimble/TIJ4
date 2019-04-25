package ru.grimble.tij4.interfaces;

abstract class Dummy {
    abstract void foo();
}

class DummyD extends Dummy {
    void foo() {}
}

public class Exercise4 {
    static void takeDummy(Dummy d) {
        ((DummyD) d).foo();
        d.foo();
    }
}
