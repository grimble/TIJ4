package ru.grimble.tij4.io;

import io.BufferedInputFile;

import java.io.*;

public class Exercise13 {

    static String file = "test.out";

    public static void main(String[] args) throws IOException {

        LineNumberReader in =
                new LineNumberReader(
                        new StringReader(
                                BufferedInputFile.read("test.txt")));

        PrintWriter out =
                new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(file)));

        String s;

        in.setLineNumber(0);

        while((s = in.readLine()) != null )
            out.format("%d: %s\n", in.getLineNumber(), s);

        out.close();

        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }

}
