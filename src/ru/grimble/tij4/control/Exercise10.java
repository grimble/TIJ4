package ru.grimble.tij4.control;

import java.util.*;

/**
 * Vampire Pair is a pair of two digit numbers
 */
class VPair {

    int n1;
    int n2;
    int product;

    VPair(int n1, int n2) {
        this.n1= n1;
        this.n2= n2;
        product= n1 * n2;
    }

    int getProduct() { return product; }

    /**
     * Vampire Pair considered to be equal when their numbers give equal products.
     * @param vp Vampire Pair to compare to
     * @return boolean
     */
    boolean equals(VPair vp) { return vp.getProduct() == getProduct(); }

    public String toString() { return String.format("%d %d", n1, n2); }

}

/**
 * For a set of four integers Vampire Pool contains al possible combinations
 * of four-digit numbers and corresponding different Vampire Pairs.
 */
class VPool {

    static int vNumberCounter;

    public static void reset() { vNumberCounter= 0; }
    public static int inc() { return ++vNumberCounter; }

    int[] digits;
    List<Integer> numbers;
    List<VPair> pairs;

    public String toString(){

        StringBuilder sb= new StringBuilder();

        sb.append("VPool ");

        for (int d : digits)
            sb.append(d);

        sb.append("\nNumbers:\n");

        for (Integer n : numbers)
            sb.append(String.format("  %d%n", n));

        sb.append("Pairs:\n");

        for (VPair vp : pairs)
            sb.append(String.format("  %s%n", vp));

        return sb.toString();

    }

    /**
     * Checks weather there is an equal pair in the pool.
     * @param vp Vampire Pair to be tested
     * @return true if pool contain a pair equal to tested
     */
    boolean hasVPair(VPair vp) {
        for(VPair thisvp : pairs)
            if (vp.equals(thisvp))
                return true;
        return false;
    }

    /**
     * Adds Vampire Pair to pool if there are no equal pairs there
     * @param newvp Vampire Pair to be added
     */
    void addUnique(VPair newvp) {
        if(!hasVPair(newvp))
            pairs.add(newvp);
    }

    /**
     * Fiils in numbers and pair by array of digits, iteratively.
     * @param data Digits source
     * @param result Buffer filled iteratively
     * @param sed Number of digits filled in in buffer
     */
    void seed(int[] data, int[] result, int sed) {

        if(sed == 3) {

            result[3] = data[0];

            // Here we have new combination of digits in result.
            // We should add it as a number to numbers
            // and add corresponding unique VPair to pairs

            if(result[1] != 0 || result[0] != 0)
                numbers.add(result[3] * 1000 + result[2] * 100 + result[1] * 10 + result[0]);

            if(result[3] != 0 && result[1] != 0)
                addUnique(new VPair(result[3] * 10 + result[2], result[1] * 10 + result[0]));

        } else {

            for (int i = 0; i < 4 - sed; i++) {

                result[sed]= data[i];

                int[] newData= new int[4 - sed - 1];

                for (int j = 0, k = 0; j < 4 - sed; j++)
                    if(j != i)
                        newData[k++]= data[j];

                seed(newData, result, sed + 1);

            }
        }

    }

    VPool(int[] digits) {

        this.digits= digits;

        numbers= new LinkedList<Integer>();

        pairs= new LinkedList<VPair>();

        seed(digits, new int[4], 0);
    }

    void showVNumbers() {
        for (VPair vp : pairs)
            for (Integer n : numbers)
                if (vp.getProduct() == n)
                    System.out.printf("%d. %d by pair %s%n", VPool.inc(), n, vp);

    }
}

public class Exercise10 {

    public static void main(String[] args) {

        VPool.reset();

        for (int i = 0; i < 10; i++)
            for (int j = i; j < 10; j++)
                for (int k = j; k < 10; k++)
                    for (int l = k; l < 10; l++) {
                        int[] digits = {i, j, k, l};
                        VPool vpl = new VPool(digits);
                        vpl.showVNumbers();
                    }
    }

    static void testVPool() {
        int[] digits = {1, 8, 2, 7};
        VPool vpl = new VPool(digits);
        System.out.println(vpl);
        vpl.showVNumbers();
    }
}

/**
 * Exercise 10 pure procedural implementation.
 * Seed recursive function from here is used in Vampire Pool class initialization.
 */
class Exercise10Procedural {

    static void seed(int number, int[] result, int[] data, int sed) {

        if(sed == 3) {
            result[3] = data[0];
            if ((result[3] * 10 + result[2]) * (result[1] * 10 + result[0]) == number)
                System.out.printf("%d%d * %d%d = %d%n", result[3], result[2], result[1], result[0], number);
        } else {

            for (int i = 0; i < 4 - sed; i++) {

                result[sed]= data[i];

                int[] newData= new int[4 - sed - 1];

                for (int j = 0, k = 0; j < 4 - sed; j++)
                    if(j != i)
                        newData[k++]= data[j];

                seed(number, result, newData, sed + 1);

            }
        }

    }

    static void testSeed() {
        int[] data= {1,8,2,7};
        seed(1827, new int[4], data, 0);
    }

}




















