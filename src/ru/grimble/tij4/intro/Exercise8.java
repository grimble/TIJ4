package ru.grimble.tij4.intro;

public class Exercise8 {

    public static void main(String[] args) {

        StaticTest st1= new StaticTest(1);
        StaticTest st2= new StaticTest(2);
        StaticTest st3= new StaticTest(3);

        System.out.println("StaticTest.i= " + StaticTest.i);

        st1.inc();
        System.out.println(st1);
        st2.inc();
        System.out.println(st2);
        st3.inc();
        System.out.println(st3);

        System.out.println("StaticTest.i= " + StaticTest.i);

    }

}
