package intro;

public class Exercise1 {

    int i;
    char c;

    public String toString() {
        return String.format("Ex.1 i= %d c= %c(%d)", i, c, (int)c);
    }

    public static void main(String[] args){
        System.out.println(new Exercise1());

    }
}
