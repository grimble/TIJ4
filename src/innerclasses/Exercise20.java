package innerclasses;

interface WithNested {
    class Nested {}
}

public class Exercise20 {
    public static void main(String[] args) {

        WithNested.Nested wnn= new WithNested.Nested();
    }
}
