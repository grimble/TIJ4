package ru.grimble.tij4.io;

import java.io.*;

public class Exercise21 {

    public static void main(String[] args) throws IOException {

        BufferedReader stdin= new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input something:");

        String newLine;
        while ((newLine= stdin.readLine()) != null && newLine.length() > 0) {
            System.out.format("%s\n", newLine.toUpperCase());
        }
    }

}
