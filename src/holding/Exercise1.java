package holding;

import java.util.ArrayList;
import java.util.Collection;

import static net.mindview.util.Print.*;

class Gebril {
    private static int total;
    int gebrilNumber= ++total;
    void hop() {
        printf("Gebril no %d hopping.%n", gebrilNumber);
    }
}

public class Exercise1 {
    public static void main(String[] args) {

        ArrayList<Gebril> gl= new ArrayList<Gebril>();

        for (int i=0; i < 10; i++) {
            gl.add(new Gebril());
        }

        for (int i=0; i < 10; i++) {
            gl.get(i).hop();
        }

        print(gl);
    }
}
