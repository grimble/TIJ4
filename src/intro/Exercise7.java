package intro;

class StaticTest {

    static int i = 47;

    static int getI() { return i; }

    int inc() { return i++; }
    int dec() { return i--; }

    int no;

    StaticTest(int no) { this.no= no; }

    public String toString() { return super.toString() + " no." + no + " i= " + i; }

}

class Incrementable {
    static void increment() { StaticTest.i++; }
}


public class Exercise7 {

    public static void main(String[] args){

        System.out.printf("Incrementable i= %d%n", StaticTest.getI());

        Incrementable sf = new Incrementable();

        sf.increment();

        System.out.printf("Incrementable i= %d%n", StaticTest.getI());

        Incrementable.increment();

        System.out.printf("Incrementable i= %d%n", StaticTest.getI());

    }

}
