package ru.grimble.tij4.io;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Data IO streams read and write companion two methods
 */
class IOMethod {

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

    public IOMethod(String name, Class dataType, Method readMethod, Method writeMethod) {
        this.name=name;
        this.dataType=dataType;
        this.readMethod=readMethod;
        this.writeMethod=writeMethod;
    }

    public IOMethod(String name, Class dataType) {
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
 * Test harness for companion IO classes.
 * Attempts to consequently write and read by corresponding IO methods and compare results.
 */
class IOClassTest {

    Class InputClass;
    Class OutputClass;

    List<IOMethod> dataIOMethods;
    List<IOMethod.TestData> writtenTestData;

    public IOClassTest(Class inputClass, Class outputClass) {
        InputClass= inputClass;
        OutputClass= outputClass;
        dataIOMethods= getIOMethods();
    }

    /**
     * Finds data io streams r/w companion methods
     * @return  a list of methods that read and write the same data type
     */
    List<IOMethod> getIOMethods() {

        List<IOMethod> dataIOMethods= new LinkedList<IOMethod>();

        for (Method writeMethod : OutputClass.getMethods()) {

            // skip inhereted methods
            if (writeMethod.getDeclaringClass() != OutputClass)
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
                readMethod=InputClass.getDeclaredMethod("read" + name);
            } catch (NoSuchMethodException e) {
                continue;
            }

            dataIOMethods.add(new IOMethod(
                    name,
                    dataType,
                    readMethod,
                    writeMethod
            ));

        }

        return dataIOMethods;
    }

    void write(Object outputStream) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        writtenTestData= new LinkedList<IOMethod.TestData>();

        System.out.println("\nWriting test data");

        for (IOMethod dataIOMethod : dataIOMethods) {

            try {
                Object data=IOMethod.generateData(dataIOMethod.dataType);
                dataIOMethod.writeMethod.invoke(outputStream, data);
                writtenTestData.add(dataIOMethod.new TestData(data));
                System.out.format("Wrote %s via %s %s\n",
                        data, dataIOMethod.writeMethod.getName(), dataIOMethod.dataType.getName());
            } catch (InvocationTargetException e) {
                System.out.format("Error writing %s data type\n", dataIOMethod.dataType.getName());
                e.printStackTrace();
            }

        }

        OutputClass.getMethod("close").invoke(outputStream);
        
    }

    void read(Object inputStream) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        System.out.println("\nReading test data");

        for (IOMethod.TestData testData : writtenTestData) {

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

        InputClass.getMethod("close").invoke(inputStream);

    }
}

public class Exercise15 {

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        IOClassTest test= new IOClassTest(DataInputStream.class, DataOutputStream.class);

        DataOutputStream outputStream=
                new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("test.bin")));

        test.write(outputStream);

        DataInputStream inputStream=
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("test.bin")));

        test.read(inputStream);

    }
}
















































