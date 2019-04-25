package ru.grimble.tij4.innerclasses;

interface WithNested {
    class Nested {}
}

public class Exercise20 {
    public static void main(String[] args) {

        WithNested.Nested wnn= new WithNested.Nested();
    }
}
