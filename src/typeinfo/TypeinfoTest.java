package typeinfo;


import java.io.PrintStream;
import java.util.Formatter;

interface Jumper {}
interface Swimmer {}
interface Runner {}
interface Climber {}

class Person {}

class Athlet extends Person implements Jumper {}

class Fitnesser extends Person implements Climber {}

class LineFormatter {
    private Formatter f;
    public LineFormatter(PrintStream ps) {
        f= new Formatter(ps);
    }
    public void format(String format, Object... oo) {
        f.format(format + "\n", oo);
    }
}

public class TypeinfoTest {

    public static void main(String[] args) {

        LineFormatter lf= new LineFormatter(System.out);

        Person a= new Athlet();

        Class aClass= a.getClass();

        lf.format("aClass= %s", aClass.getCanonicalName());
        lf.format("Implements");
        for (Class ifs : aClass.getInterfaces())
            lf.format("  %s", ifs.getSimpleName());

        Class<Athlet> aSubClass= aClass.asSubclass(Athlet.class);
        lf.format("aSubClass= %s", aSubClass.getCanonicalName());

        Class aSuperClass= aClass.getSuperclass();
        lf.format("aSuperClass= %s", aSuperClass.getCanonicalName());

    }
}
