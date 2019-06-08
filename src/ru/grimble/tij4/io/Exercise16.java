package ru.grimble.tij4.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;

public class Exercise16 {

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        IOClassTest test= new IOClassTest(RandomAccessFile.class, RandomAccessFile.class);

//        System.out.format("%s\n", test);

        RandomAccessFile raf;

        raf= new RandomAccessFile("testraf.bin", "rw");

        test.write(raf);

        raf= new RandomAccessFile("testraf.bin", "r");

        test.read(raf);

    }

}
