package intro;

public class Exercise6 {

    static int storage(String s) {
        return s.length() * 2;
    }

    public static void main(String[] args){

        String s= "Black diamond";

        System.out.printf("Storage for '%s' is %d", s, storage(s));

    }
}
