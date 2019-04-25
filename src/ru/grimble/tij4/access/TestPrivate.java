package ru.grimble.tij4.access;

class Parent {
    protected void foo() {}
}

class Child extends Parent {}

public class TestPrivate {
    public static void main(String... args) {

        Child c= new Child();

        Parent p= (Parent)c;

        p.foo();
    }
}
