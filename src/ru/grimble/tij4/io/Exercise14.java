package ru.grimble.tij4.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

public class Exercise14 {

    static long measureWriter(PrintWriter pw) {

        Random r= new Random(47);

        Date start= new Date();

        for (int i=0; i < 10000 ; i++) {
            StringBuilder sb= new StringBuilder();
            for (int j=0; j < 1000; j++) {
                sb.append((char)(r.nextInt(122-32) + 32));
            }
            pw.println(sb.toString());
        }

        pw.close();

        Date end= new Date();

        return end.getTime() - start.getTime();

    }

    public static void main(String[] args) throws IOException {

        long buffered= measureWriter(
                new PrintWriter(
                        new BufferedWriter(
                                new FileWriter("buffered.txt"))));

        long plain= measureWriter(
                new PrintWriter(
                        new FileWriter("plain.txt")));

        System.out.format("Buffered   %d\n", buffered);
        System.out.format("Plain      %d\n", plain);
        System.out.format("Difference %d\n", plain - buffered);

    }

}
