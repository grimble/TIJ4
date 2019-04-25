package ru.grimble.tij4.initialization;

public class Exercise22 {

    public static void main(String[] args) {

        String descr= "";

        for (Bills b : Bills.values()) {
            switch (b) {
                case TEN:
                    descr= "Takes two to take a bus";
                    break;
                case FIFTY:
                    descr= "Can drink cheep coffee";
                    break;
                case ONE_HUNDRED:
                    descr= "Can ride a taxi but not for long";
                    break;
                case TWO_HUNDRED:
                    descr= "Taxi 'cross the town";
                    break;
                case FIVE_HUNDRED:
                    descr= "Entry level meal with no spirits";
            }
            System.out.printf("Bill %s: %s.%n", b, descr);
        }

    }
}
