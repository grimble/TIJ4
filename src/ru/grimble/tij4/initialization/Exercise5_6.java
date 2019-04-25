package ru.grimble.tij4.initialization;

class Dog {

    String name;

    public Dog(String name) { this.name= name; }

    void showBark(String s) { System.out.println(name + " does " + s); }

    void bark(int i) { showBark("Integer barking " + i); }
    void bark(float f) { showBark("Float barking " + f); }
    void bark(int i, float f) { showBark("Inloat barking " + i + " " + f); }
    void bark(float f, int i) { showBark("Fleger barking " + f + " " + i); }

}


public class Exercise5_6 {
    public static void main(String[] args) {

        Dog bobik= new Dog("Bobik");

        bobik.bark(1);
        bobik.bark((float)1.1);
        bobik.bark(1, (float)1.1);
        bobik.bark((float)1.1, 1);

    }
}
