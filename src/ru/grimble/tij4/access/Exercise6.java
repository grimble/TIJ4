package ru.grimble.tij4.access;

import static net.mindview.util.Print.*;

class DataStore {
    protected int i;
    protected int j;
    DataStore(int i, int j) {
        this.i= i;
        this.j= j;
    }
}

public class Exercise6 {
    public static void main(String... args) {
        DataStore ds= new DataStore(1,2);
        print(ds.i + ds.j);

    }
}
