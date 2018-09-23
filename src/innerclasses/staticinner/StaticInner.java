package innerclasses.staticinner;

import static net.mindview.util.Print.*;

class Outer {
    static class Inner {
        int i;
        Inner(int i) { this.i= i; }

        @Override
        public String toString() {
            return super.toString() + "\n" + getClass().getName() + " " + String.valueOf(i);
        }
    }
}

public class StaticInner {
    public static void main(String[] args) {

        Outer.Inner oi5= new Outer.Inner(5);
        Outer.Inner oi7= new Outer.Inner(7);
        print(oi5);
        print(oi7);

    }
}
