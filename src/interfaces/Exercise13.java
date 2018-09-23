package interfaces;

interface I1 {}

interface I11 extends I1 {}
interface I12 extends I1 {}

class I2 implements I11, I12 {};

public class Exercise13 {
}
