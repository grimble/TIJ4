package ru.grimble.tij4.reusing;

import static net.mindview.util.Print.*;

class Containable {

    Object container;

    Containable() {
        print(String.format("new Containable %s", this));
    }

    Containable(Object container) {
        this.container= container;
        print(String.format("new Containable %s in %s", this, container));
    }

    void dispose() {
        print("Containable dispose");
        print(String.format("disposing %s in %s", this, container));
    }

}

class Component1 extends Containable {
    Component1(Object container) { super(container); }
}

class Component2 extends Containable {
    Component2(Object container) { super(container); }

}

class Component3 extends Containable {
    Component3(Object container) { super(container); }
}

class Root extends Containable {

    Component1 c1= new Component1("Root");
    Component2 c2= new Component2("Root");
    Component3 c3= new Component3("Root");

    Root() { print("new Root"); }

    void dispose() {
        print("Root dispose");
        print("Disposing components");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        print("Disposing superclass");
        super.dispose();
    }

}

class Stem extends Root {

    Component1 c1= new Component1("Stem");
    Component2 c2= new Component2("Stem");
    Component3 c3= new Component3("Stem");

    @Override
    public String toString() {
        return String.format("%s%n c1= %s%n c2= %s%n c3= %s", super.toString(), c1, c2, c3);
    }

    void dispose() {
        print("Stem dispose");
        print("Disposing components");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        print("Disposing Root content");
        super.dispose();
        print("Disposing Stem content");
    }

    Containable getSuperC1() { return super.c1; }

}

public class Exercise9 {
    public static void main(String[] args) {

        print("Creating Stem");
        Stem s= new Stem();
        print("Created Stem");
        print(s);
        printf("Super c1 is %s%n", s.getSuperC1());
        print("Disposing Stem");
        s.dispose();
    }
}
