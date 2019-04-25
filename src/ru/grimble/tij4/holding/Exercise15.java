package ru.grimble.tij4.holding;

import net.mindview.util.Stack;

public class Exercise15 {
    public static void main(String[] args) {

        StringBuilder sb= new StringBuilder("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");

        Stack<Character> s= new Stack<Character>();

        for (int i=0; i < sb.length(); i++) {

            char c= sb.charAt(i);

            switch (c) {
                case '+': {
                    s.push(sb.charAt(++i));
                    break;
                }
                case '-': {
                    System.out.println(s.pop());
                    break;
                }
            }
        }

    }
}
