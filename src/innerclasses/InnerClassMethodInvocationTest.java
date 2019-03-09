package innerclasses;

import java.lang.reflect.*;

/**
 * Static inner class methods 'overloading' via reflection.
 * An example of general function for calling certain method for
 * inner class hierarchy.
 */

/**
 * Outer class
 */
class Foo {
    /**
     * Static inner class
     */
    public static class Bar {

        public static void buz() { System.out.println("Foo's Bar is buzzing"); }

        /**
         * Creates outer class object
         * @return New outer class object
         */
        public static Foo newOuter() { return new Foo(); }

    }
}

/**
 * Outer class extention
 */
class Boo extends Foo {
    /**
     * Static inner class redefined
     */
    public static class Bar {

        public static void buz() { System.out.println("Boo's Bar is buzzing"); }

        /**
         * Creates outer class object
         * @return New outer class object
         */
        public static Boo newOuter() { return new Boo(); }

    }
}

public class InnerClassMethodInvocationTest {

    /**
     * Calls newOuter method for a class in Foo.Bar hierarchy
     * @param fooBarClass Fo.Bar class or its extention
     * @return new base class instance
     */
    public static Foo newOuter(Class<? extends Foo.Bar> fooBarClass) {
        try {
            Method createMethod= fooBarClass.getMethod("newOuter");
            System.out.println("newOuter method got");
            try {
                Foo f= (Foo)createMethod.invoke(null);
                System.out.println("newOuter method created new instance");
                return f;
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("..oops! Returning null");
        return null;
    }

    public static void main(String []args) {

        // Populating an array of classes with inner class and its extension class
        Class[] clss= { Foo.Bar.class, Boo.Bar.class };

        // Iterating through array of classes
        for ( Class cls : clss ) {

            // For each class calling its method that creates new outer class instance
            Foo f= newOuter(cls);

            // Verifying that extension inner class produced extension outer class object
            System.out.format("Class %s made new object %s\n", cls.getName(), f.getClass().getSimpleName());

        }

    }

}


















