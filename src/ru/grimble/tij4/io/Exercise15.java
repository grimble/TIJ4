package ru.grimble.tij4.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Exercise15 {

    public static void main(String[] args) {

        Set<Class> dataTypes= new HashSet<Class>();

        for (Method method : DataOutputStream.class.getMethods()) {

            // skip inhereted methods
            if (method.getDeclaringClass() != DataOutputStream.class)
                continue;

            Class[] parameterTypes= method.getParameterTypes();

            // skip methods with no parameters
            if (parameterTypes.length == 0)
                continue;

            Class dataType= parameterTypes[0];
            String methodName= method.getName();

            // process only methods that write smth
            if (!methodName.startsWith("write"))
                continue;

            dataTypes.add(dataType);

            System.out.format("%s(%s)\n", methodName, dataType.getSimpleName());

        }

    }

}
