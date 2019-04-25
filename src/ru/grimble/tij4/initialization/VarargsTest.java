package ru.grimble.tij4.initialization;

public class VarargsTest {
//    static void f(Character... cc) {
//        System.out.println("f(Character... cc)");
//    }

    static void f(float i, Character... cc) {
        System.out.println("---");
        System.out.printf("i= %f%n", i);
        System.out.printf("cc.length= %d%n", cc.length);
        for (Character c : cc)
            System.out.printf("%c", c);
        System.out.println();
    }

    public static void main(String... args) {
        int i= 9;
        f(i, 'f');
        f( 'i');
    }
}
