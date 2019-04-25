package ru.grimble.tij4.initialization;

class Tank {

    static int count;

    boolean isFull;

    void afterConstruction() {
        count++;
        System.out.printf("Constructing %s Tank no. %d.%n", (isFull ? "full" : "empty"), count);
    }

    Tank() { afterConstruction(); }

    Tank(boolean isFull) {
        this.isFull= isFull;
        afterConstruction();
    }

    protected void finalize() {
        if(isFull)
            System.out.println("Tank not ready for termination.");
    }

}

public class Exercise12 {
    public static void main(String[] args) {
        new Tank();
        new Tank(true);
        System.out.printf("Overall %d tanks.%n", Tank.count);
        System.out.println("Collecting garbage.");
        System.gc();
    }
}
