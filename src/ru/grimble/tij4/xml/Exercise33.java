package ru.grimble.tij4.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

public class Exercise33 {

    public static void main(String[] args) throws IOException {

        Preferences prf= Preferences.userNodeForPackage(Exercise33.class);

        String baseDir= prf.get("BaseDir", "");

        System.out.format("Base dir is %s\n", baseDir);

        BufferedReader br=
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        System.out.format("Input new base dir: ");

        baseDir= br.readLine();

        prf.put("BaseDir", baseDir);

        System.out.format("OK.");
    }
}
