package ru.grimble.tij4.control;

import java.util.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

enum LetterSoundType {

    VOWEL("Vovel"),
    SOMETIMES_A_VOWEL("Sometimes a vovel"),
    CONSONANT("Consonant");

    static LetterSoundType getType(char c) {

        LetterSoundType result;

        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                result=VOWEL;
                break;
            case 'y':
            case 'w':
                result=SOMETIMES_A_VOWEL;
                break;
            default:
                result=CONSONANT;
        }

        return result;
    }

    String description;

    LetterSoundType(String description) { this.description= description; }

    @Override
    public String toString() {
        return description;
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Random rand=new Random(47);
        for (int i=0; i < 100; i++) {
            int c=rand.nextInt(26) + 'a';
            printnb((char)c + ", " + c + ": ");
            print(LetterSoundType.getType((char)c));
        }
    }
}

