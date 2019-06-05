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

        static Random r= new Random(47);

        /**
         * Produces random data for different data types
         * @param dataType  data type class
         * @return  random value of data type class
         */
        static Object generateData(Class dataType) {

            if (dataType == Boolean.TYPE)
                return r.nextBoolean();
            else if (dataType == Integer.TYPE)
                return r.nextInt();
            else if (dataType == Long.TYPE)
                return r.nextLong();
            else if (dataType == Float.TYPE)
                return r.nextFloat();
            else if (dataType == Double.TYPE)
                return r.nextDouble();
            else if (dataType == Character.TYPE)
                return (char)r.nextInt();
            else if (dataType == String.class) {
                byte[] bytes= new byte[16];
                r.nextBytes(bytes);
                return new String(bytes);
            }

            return null;

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

        // todo: verify read data

        Iterator<DataIOMethod> dataIOMethodIterator= dataIOMethods.iterator();

        DataOutputStream outputStream=
                new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("test.bin")));

        while (dataIOMethodIterator.hasNext()) {

            DataIOMethod dataIOMethod= dataIOMethodIterator.next();

            System.out.format("Data type %s, input %s, output %s\n",
                    dataIOMethod.dataType.getSimpleName(),
                    dataIOMethod.readMethod.getName(),
                    dataIOMethod.writeMethod.getName()
            );

            try {
                Object data= DataIOMethod.generateData(dataIOMethod.dataType);
                dataIOMethod.writeMethod.invoke(outputStream, data);
                System.out.format("Invoked %s(%s)\n", dataIOMethod.writeMethod.getName(), data);
            } catch (InvocationTargetException e) {
                System.out.format("Error writing %s data type\n", dataIOMethod.dataType.getName());
                e.printStackTrace();
            }

        }

        outputStream.close();

    }

}
















































