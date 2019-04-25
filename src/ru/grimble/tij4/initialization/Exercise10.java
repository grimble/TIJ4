package ru.grimble.tij4.initialization;

class Fina {

    Fina() {
        System.out.println("Creating Fina instance.");
    }

    protected void finalize() {
        System.out.println("Finalizing Fina instance.");
    }

}

public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise10 started.");
        new Fina();
        System.out.println("Collecting garbage.");
        System.gc();
    }
}
