package ru.grimble.tij4.intro;

public class Exercise10 {

    public static void main(String[] args) {

        System.out.println("args= " + args + " args.length= " + args.length);

        int length= args.length < 3 ? args.length : 3;

        for (int i = 0; i < length; i++) {
            System.out.printf("arg%d= %s%n", i, args[i]);
        }

    }

}
