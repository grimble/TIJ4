package ru.grimble.tij4.interfaces;

abstract class ATest {
    static String s() { return "123"; }
}

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println(ATest.s());
    }
}
