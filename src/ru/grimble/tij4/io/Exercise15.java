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

        class TestData {
            Object data;

            public TestData(Object data) {
                this.data=data;
            }

            public Method getReadMethod() {
                return readMethod;
            }
        }

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
            else if (dataType == Short.TYPE)
                return (short)r.nextInt(Short.MAX_VALUE);
            else if (dataType == Long.TYPE)
                return r.nextLong();
            else if (dataType == Float.TYPE)
                return r.nextFloat();
            else if (dataType == Double.TYPE)
                return r.nextDouble();
            else if (dataType == Character.TYPE)
                return (char)r.nextInt(Character.MAX_VALUE);
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

        List<DataIOMethod> dataIOMethods=getDataIOMethods();

        List<DataIOMethod.TestData> writtenTestData=new LinkedList<DataIOMethod.TestData>();

        DataOutputStream outputStream=
                new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("test.bin")));

        System.out.println("Writing test data");

        for (DataIOMethod dataIOMethod : dataIOMethods) {

            try {
                Object data=DataIOMethod.generateData(dataIOMethod.dataType);
                dataIOMethod.writeMethod.invoke(outputStream, data);
                writtenTestData.add(dataIOMethod.new TestData(data));
                System.out.format("Wrote %s via %s %s\n",
                        data, dataIOMethod.writeMethod.getName(), dataIOMethod.dataType.getName());
            } catch (InvocationTargetException e) {
                System.out.format("Error writing %s data type\n", dataIOMethod.dataType.getName());
                e.printStackTrace();
            }

        }

        outputStream.close();

        DataInputStream inputStream=
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("test.bin")));

        Iterator<DataIOMethod.TestData> writtenTestDataIterator=writtenTestData.iterator();

        System.out.println("\nReading test data");

        for (DataIOMethod.TestData testData : writtenTestData) {

            // todo: verify read data

            try {
                Object data=testData.getReadMethod().invoke(inputStream);
                System.out.format("Read %s via %s %s\n",
                        data,
                        testData.getReadMethod().getName(),
                        (data.equals(testData.data) ? "passed" : "failed")
                );
            } catch (InvocationTargetException e) {
                System.out.format("Error reading via %s\n", testData.getReadMethod().getName());
            }

        }

        inputStream.close();
    }
}
















































