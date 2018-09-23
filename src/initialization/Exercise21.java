package initialization;

enum Bills {
    TEN, FIFTY, ONE_HUNDRED, TWO_HUNDRED, FIVE_HUNDRED
}

public class Exercise21 {

    public static void main(String[] args) {
        for (Bills c : Bills.values())
            System.out.printf("Bill %s ordinal %s%n", c, c.ordinal());
    }

}
