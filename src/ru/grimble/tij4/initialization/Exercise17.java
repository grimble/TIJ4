package ru.grimble.tij4.initialization;

class StringConst {

    StringConst(String s) { System.out.printf("Constructing StringConst %s.%n", s); }
}

public class Exercise17 {
    public static void main(String[] args) {

        System.out.println("Creating array of StringConst references.");
        StringConst[] sc= new StringConst[3];
        System.out.printf("Created array of %d elements.%n", sc.length);

        System.out.println("Assinging values to array of StringConst references elements.");
        sc[0]= new StringConst("1");
        sc[1]= new StringConst("2");
        sc[2]= new StringConst("3");
        System.out.println("Done.");



    }
}
