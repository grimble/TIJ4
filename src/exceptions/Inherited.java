/**
 * Reporting added info while throwing inherited exceptions
 */
package exceptions;

/**
 * Base exception
 */
class MyException extends Exception {
    int state;
    public MyException(int state) {
        this.state= state;
    }
    @Override
    public String toString() {
        return super.toString() + " state= " + state;
    }
}

/**
 * Base class
 */
class MyClass {
    int no;
    public MyClass(int no){
        this.no= no;
    }
    void foo() throws MyException {
        throw new MyException(no);
    }
}

/**
 * Derived exception can bring additional info on derived class
 * that base exception doesn't know of
 */
class MyException1 extends MyException {
    String stateDescription;
    public MyException1(int state, String stateDescription) {
        super(state);
        this.stateDescription= stateDescription;
    }
    @Override
    public String toString() {
        return super.toString() + " stateDescription= " + stateDescription;
    }
}

/**
 * Derived class with some extra info
 */
class MyClass1 extends MyClass {
    String name;
    public MyClass1(int no, String name){
        super(no);
        this.name= name;
    }

    /**
     * Drived foo() should throw MyException, but we can make it
     * to be MyException1 for extra info placeholders MyException lacks
     * @throws MyException
     */
    void foo() throws MyException {
        throw new MyException1(no, name);
    }
}

public class Inherited {

    /**
     * Exception processor works with them both
     * @param mc    MyClass foo to be called of
     */
    public static void safeCall(MyClass mc) {
        try {
            mc.foo();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MyException {

        safeCall(new MyClass(1));
        safeCall(new MyClass1(2, "two"));

    }
}
