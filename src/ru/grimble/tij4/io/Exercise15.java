package ru.grimble.tij4.io;

import sun.awt.image.ImageWatched;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.util.*;

public class Exercise15 {

    static class DataIOMethod {

        String name;
        Class dataType;

        public DataIOMethod(String name, Class dataType) {
            this.name=name;
            this.dataType=dataType;
        }

    }

    public static void main(String[] args) {

        List<DataIOMethod> dataIOMethods= new LinkedList<DataIOMethod>();

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

            dataIOMethods.add(new DataIOMethod(methodName.replaceFirst("write", ""), dataType));

        }

        Iterator<DataIOMethod> dataIOMethodIterator= dataIOMethods.iterator();
        System.out.format("%s %s\n", "Name", "Data type");
        System.out.format("--------------------------------\n");
        while (dataIOMethodIterator.hasNext()) {
            DataIOMethod dataIOMethod= dataIOMethodIterator.next();
            System.out.format("%s %s\n", dataIOMethod.name, dataIOMethod.dataType.getSimpleName());
        }

    }

}
