package ru.grimble.tij4.control;

public class Execise9 {

    static void fibo(int number){
        switch(number) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("1");
                System.out.println("1");
                break;
            default:
                System.out.println("1");
                System.out.println("1");
                int p1 = 1, p2 = 1;
                for (int i = 0; i < number - 2; i++) {
                    int res= p1 + p2;
                    System.out.println(res);
                    p1 = p2;
                    p2 = res;
                }
        }

    }

    public static void main(String[] args){
        fibo(10);
    }
}
