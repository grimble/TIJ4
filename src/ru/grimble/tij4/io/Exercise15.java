package ru.grimble.tij4.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Exercise15 {

    public static void main(String[] args) {

        Set<String> readMethodNames= new HashSet<String>();

        for (Method method : DataInputStream.class.getMethods()) {

            String methodName= method.getName();
            Class retType= method.getReturnType();

            if (!methodName.startsWith("read") || readMethodNames.contains(methodName) || retType == Void.TYPE)
                continue;

            readMethodNames.add(methodName);

            System.out.format("%s %s()\n", retType.getSimpleName(), methodName);

        }

    }

}
