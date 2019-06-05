package ru.grimble.tij4.io;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Exercise15 {

    /**
     * Data IO streams read and write companion methods
     */
    static class DataIOMethod {

        String name;
        Class dataType;
        Method readMethod;
        Method writeMethod;

        public DataIOMethod(String name, Class dataType, Method readMethod, Method writeMethod) {
            this.name=name;
            this.dataType=dataType;
            this.readMethod=readMethod;
            this.writeMethod=writeMethod;
        }

        public DataIOMethod(String name, Class dataType) {
            this.name=name;
            this.dataType=dataType;
        }

    }

    /**
     * Finds data io streams r/w companion methods
     * @return  a list of methods that read and write the same data type
     */
    static List<DataIOMethod> getDataIOMethods() {

        List<DataIOMethod> dataIOMethods= new LinkedList<DataIOMethod>();

        for (Method writeMethod : DataOutputStream.class.getMethods()) {

            // skip inhereted methods
            if (writeMethod.getDeclaringClass() != DataOutputStream.class)
                continue;

            Class[] parameterTypes= writeMethod.getParameterTypes();

            // skip methods with no parameters
            if (parameterTypes.length == 0)
                continue;

            Class dataType= parameterTypes[0];
            String methodName= writeMethod.getName();

            // process only methods that write smth
            if (!methodName.startsWith("write"))
                continue;

            String name= methodName.replaceFirst("write", "");

            Method readMethod;
            try {
                readMethod=DataInputStream.class.getDeclaredMethod("read" + name);
            } catch (NoSuchMethodException e) {
                continue;
            }

            dataIOMethods.add(new DataIOMethod(
                    name,
                    dataType,
                    readMethod,
                    writeMethod
            ));

        }

        return dataIOMethods;
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {

        List<DataIOMethod> dataIOMethods= getDataIOMethods();

        // todo: write data
        // todo: read data
        // todo: verify read data

        Iterator<DataIOMethod> dataIOMethodIterator= dataIOMethods.iterator();

        DataOutputStream outputStream=
                new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("test.bin")));

        while (dataIOMethodIterator.hasNext()) {

            DataIOMethod dataIOMethod= dataIOMethodIterator.next();

            System.out.format("Data %s, input %s, output %s\n",
                    dataIOMethod.dataType.getSimpleName(),
                    dataIOMethod.readMethod.getName(),
                    dataIOMethod.writeMethod.getName()
            );

            Object data=null;
            try {
                data=dataIOMethod.dataType.newInstance();
            } catch (InstantiationException e) {
                System.out.format("InstantiationException for %s\n", dataIOMethod.dataType);
                continue;
            }

            try {
                dataIOMethod.writeMethod.invoke(outputStream, data);
            } catch (InvocationTargetException e) {
                System.out.format("Error writing %s", dataIOMethod.dataType.getName());
                e.printStackTrace();
            }

        }

        outputStream.close();

    }

}
















































