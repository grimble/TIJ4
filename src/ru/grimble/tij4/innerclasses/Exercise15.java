package ru.grimble.tij4.innerclasses;

import static net.mindview.util.Print.*;

class Locked {
    int i;
    Locked(int i) {
        // forgot to initialize i
    }

    @Override
    public String toString() {
        return super.toString() + "i= " + i;
    }
}

class ModifiedReturn {

    Locked getLocked(int i) {

        return new Locked(1) {
            {
                this.i= i; // filling initialization gap
            }

        };
    }

}

public class Exercise15 {
    public static void main(String[] args) {

        ModifiedReturn mr= new ModifiedReturn();

        print(new Locked(47));
        print(mr.getLocked(47));
    }
}
