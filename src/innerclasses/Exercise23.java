package innerclasses;

import static net.mindview.util.Print.*;

interface U {
    void foo();
    void bar();
    void buz();
}

class A {
    U makeU() {
        return new U() {
            @Override
            public void foo() {
                print("foo " + this);
            }

            @Override
            public void bar() {
                print("bar" + this);
            }

            @Override
            public void buz() {
                print("buz" + this);

            }
        };
    }
}

class B {

    static int SIZE= 3;

    U[] uu= new U[SIZE];

    boolean takeU(U u) {
        for (int i= 0; i < 3; i++) {
            if (uu[i] == null) {
                uu[i]= u;
                return true;
            }
        }
        return false;
    }

    void cleanU(int i) {
        uu[i]= null;
    }

    void executeU() {
        for (U u : uu) {
            if (u != null) {
                u.foo();
                u.bar();
                u.buz();
            }
        }
    }
}


public class Exercise23 {
    public static void main(String[] args) {

        A[] aa= new A[B.SIZE];

        for (int i=0; i < B.SIZE; i++) {
            aa[i]= new A();
        }

        B b= new B();

        for (int i=0; i < B.SIZE; i++) {
            b.takeU(aa[i].makeU());
        }

        b.executeU();


    }
}