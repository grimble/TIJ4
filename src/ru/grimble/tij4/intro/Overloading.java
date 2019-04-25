package ru.grimble.tij4.intro;

import static net.mindview.util.Print.*;

/**
 * Demo class containing same methods with different parameters.
 */
class Tree {

    /**
     * Defines how tall the tree is.
     */
    int height;

    /**
     * Constructor with no parameters.
     */
    Tree() {
        print("Planting a seedling");
        height = 0;
    }

    /**
     * Parametrized constructor.
     * @param initialHeight Newly born tree height.
     */
    Tree(int initialHeight) {
        height = initialHeight;
        print("Creating new Tree that is " +
                height + " feet tall");
    }

    /**
     * Method with no parameters.
     */
    void info() {
        print("Tree is " + height + " feet tall");
    }

    /**
     * Method with the same name but one parameter.
     * @param s What should be put before info.
     */
    void info(String s) {
        print(s + ": Tree is " + height + " feet tall");
    }
}

/**
 * Demonstrates that change in parameters causes different method call.
 */
public class Overloading {

    static void treeInfo(Tree t) {
        t.info();
        t.info("overloaded method");
    }

    /**
     * Plants a tree and consistently creates trees from 1 to 5 units tall.
     * For each tree displays it's info first with no parameters than with a string.
     * @param args Parameters array. Not used here.
     */
    public static void main(String[] args) {

        treeInfo(new Tree());

        for(int i = 0; i < 5; i++) {
            treeInfo(new Tree(i));
        }

    }
}
