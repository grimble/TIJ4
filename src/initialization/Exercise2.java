package initialization;

class ConstructorDemo {

    String sDef= "Init by definition";
    String sCon;


    public ConstructorDemo() {
        System.out.printf("sDef= %s%n", sDef);
        System.out.printf("sCon= %s%n", sCon);
    }

}

public class Exercise2 {

    public static void main(String[] args) {
        new ConstructorDemo();
    }
}
