package intro;

class DataOnly {

    int i;
    double d;
    boolean b;

    public String toString(){

        return String.format("%s i= %d d= %f b= %b", super.toString(), i, d, b);

    }
}

public class Exercise45 {

    public static void main(String[] args){

        DataOnly data = new DataOnly();
        DataOnly dataI = new DataOnly();

        dataI.i= 1;
        dataI.d= 1.234567;
        dataI.b= true;

        System.out.printf("Not initialized %s", data.toString());
        System.out.println();
        System.out.printf("Initialized %s", dataI.toString());

    }

}
