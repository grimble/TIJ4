package ru.grimble.tij4.interfaces;

import java.nio.*;
import java.util.Random;
import java.util.Scanner;

import static net.mindview.util.Print.*;

class CharSequenceProducer implements Readable {

    Random r= new Random(777);

    int length;

    CharSequenceProducer(int length) {
        this.length= length;
    }

    private char getChar() {
        return (char)r.nextInt(Character.MAX_VALUE);
    }

    private CharSequence getSequence() {
        char[] csq= new char[length];
        for (int i=0; i < length; i++)
            csq[i]= getChar();
        return new String(csq);
    }

    public int read(CharBuffer cb) {
        cb.append(getSequence());
        return -1;
    }

    class Test {
        public void run() {
            print(CharSequenceProducer.this.getChar());
            print(CharSequenceProducer.this.getSequence());
        }
    }

}

public class Exercise16 {
    public static void main(String[] args) {

        CharSequenceProducer csp= new CharSequenceProducer(5);

        (csp.new Test()).run();

        Scanner s= new Scanner(csp);

        print(s.next());

    }
}
