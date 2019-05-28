package ru.grimble.tij4.io;

import java.io.*;

public class Exercise12 {

    static class ShadowWriteOutputModifier implements Exercise7.OutputModifier {

        String fileName;
        PrintWriter pr;

        ShadowWriteOutputModifier(String fileName) throws IOException {
            this.fileName= fileName;
            pr= new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        }

        @Override
        public String modify(String s) {
            pr.println(s);
            return s;
        }

        @Override
        public String toString() {
            return String.format("%s fileName= %s", this.getClass().getName(), fileName);
        }

        public void close() {
            pr.close();
        }
    }

    public static void main(String[] args) throws IOException {

        ShadowWriteOutputModifier modifier= new ShadowWriteOutputModifier(args[1]);

        Exercise7.printReversed(args[0], modifier);

        modifier.close();

    }

}
