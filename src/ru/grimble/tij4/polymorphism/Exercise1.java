package ru.grimble.tij4.polymorphism;

import static net.mindview.util.Print.*;

class Cycle {
    int wheelsNum;
    int getWheelsNum() { return wheelsNum; }
}

class Rider {
    void ride(Cycle c) {
        printf("Rider.ride Cycle %s on %d wheels%n", c, c.getWheelsNum());
    }
}

class Unicycle extends Cycle {
    { wheelsNum= 1; }
}
class Bicycle extends Cycle {
    { wheelsNum= 2; }
}
class Tricycle extends Cycle {
    { wheelsNum= 3; }
}

public class Exercise1 {
    public static void main(String[] args) {

        Rider r= new Rider();

        r.ride(new Unicycle());
        r.ride(new Bicycle());
        r.ride(new Tricycle());

    }
}
