package ru.grimble.tij4.innerclasses;

import static net.mindview.util.Print.*;

interface Cycle {
    void ride();
    interface CycleFactory {
        Cycle produce();
    }
}

class Bicycle implements Cycle {

    static CycleFactory factory= new CycleFactory() {
        @Override
        public Cycle produce() {
            return new Bicycle();
        }
    };

    public void ride() { print("A bicycle is being rided."); }
}

class Tricycle implements Cycle {

    static CycleFactory factory= new CycleFactory() {
        @Override
        public Cycle produce() {
            return new Tricycle();
        }
    };

    public void ride() { print("A tricycle is being rided."); }
}

class Rider {
    void ride(Cycle c) {
        print("Riding " + c);
        c.ride();
    }
}

public class Exercise19 {
    public static void main(String[] args) {

        (new Rider()).ride(Bicycle.factory.produce());
        (new Rider()).ride(Tricycle.factory.produce());
    }
}
