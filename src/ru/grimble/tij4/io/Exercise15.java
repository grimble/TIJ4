package ru.grimble.tij4.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Exercise15 {

    public static void main(String[] args) {

        Set<String> methodNames= new HashSet<String>();
        Set<Class> dataTypes= new HashSet<Class>();

        for (Method method : DataOutputStream.class.getMethods()) {

            Class[] parameterTypes= method.getParameterTypes();

            if (parameterTypes.length == 0)
                continue;

            Class dataType= parameterTypes[0];
            String methodName= method.getName();

            if (!methodName.startsWith("write") || methodNames.contains(methodName) || dataType == Void.TYPE)
                continue;

            methodNames.add(methodName);

            dataTypes.add(dataType);

            System.out.format("%s %s()\n", dataType.getSimpleName(), methodName);

        }

    }

}
