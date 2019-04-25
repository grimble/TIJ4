package ru.grimble.tij4.initialization;

class DefaultConprint {

    public DefaultConprint() {
        System.out.println("Default constructor for DefaultConprint");
    }

    public DefaultConprint(String s) {
        this();
        System.out.printf("String parameter constructor s= %s%n", s);
    }

}

public class Exercise3_4 {
    public static void main(String[] args) {

        new DefaultConprint("Initialization string");

    }

}
