package ru.grimble.tij4.io;

import java.io.IOException;

public class Exercise9 {

    public static void main(String[] args) throws IOException {

        Exercise7.printReversed("test.txt", new Exercise7.OutputModifier() {
            @Override
            public String modify(String s) {
                return s.toUpperCase();
            }
            @Override
            public String toString() { return "upcase"; }
        });

    }

}
