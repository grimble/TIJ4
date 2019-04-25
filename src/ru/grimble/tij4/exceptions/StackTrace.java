/**
 * Stack passing to newly created exception when catching
 */
package ru.grimble.tij4.exceptions;

public class StackTrace {

    static void e() throws Exception {

        try {
            f();
        } catch (Exception e) {
            Exception ee= new Exception();
            ee.setStackTrace(e.getStackTrace());
            throw ee;
        }
    }

    static void f() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {

        e();

    }
}
