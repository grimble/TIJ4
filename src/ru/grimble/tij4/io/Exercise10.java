package ru.grimble.tij4.io;

import java.io.IOException;
import java.util.regex.Pattern;

public class Exercise10 {

    public static void main(String[] args) throws IOException {

        final Pattern p= Pattern.compile(args[1]);

        Exercise7.printReversed(args[0], new Exercise7.OutputModifier() {
            @Override
            public String modify(String s) {
                return p.matcher(s).matches() ? s : "skip: " + s;
            }

            @Override
            public String toString() {
                return "pattern " + p;
            }
        });

    }
}
