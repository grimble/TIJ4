package ru.grimble.tij4.reusing;

import static net.mindview.util.Print.*;

class A {

    A(int i) {
        print("A");
    }
}

class B {

    B() {
        print("B");
    }
}

class C extends A {

    B b= new B();

    C() {
        super(9);
        int i= 1;
    }

}

public class Exercise5 {

    public static void main(String[] args) {

        C c= new C();
    }

}
