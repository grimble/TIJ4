package ru.grimble.tij4.initialization;

class TwoConst {

    TwoConst(int i, String s) {
        this(s);
        System.out.println("Integer argument constuctor " + i);
    }

    TwoConst(String s) {
        System.out.println("String argument constuctor" + s);
    }

}

public class Exercise9 {
    public static void main(String[] args) {
        new TwoConst(1, "one");
    }

}
