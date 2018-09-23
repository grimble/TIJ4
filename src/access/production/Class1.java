package access.production;

public class Class1 {

    private static String ver= "PROD";

    public String toString() { return super.toString() + " ver= " + getVer(); }

    public String getVer() { return ver; }
}

