package interfaces.adaptation;

import static net.mindview.util.Print.*;

class Processable {
    public String toString() { return getClass().getSimpleName(); }
}

interface Processor {
    void process(Processable p);
}

class Processor1 implements Processor {
    public String toString() { return getClass().getSimpleName(); }
    public void process(Processable p) { print("Processor1 processes Processable"); }
}

class Harness {
    public void process(Processor pp, Processable p) {
        printf("Harness about to tell %s process %s%n", pp, p);
        pp.process(p);
    }
}

class PostProcessor {
    public String toString() { return getClass().getSimpleName(); }
    public void process(Processable p) { print("PostProcessor processes Processable"); }
}

class PostProsessor2HarnessAdaptor extends PostProcessor implements Processor {

}

public class Adaptation {

    public static void main(String[] args) {

        Processable p= new Processable();
        Harness h= new Harness();

        h.process(new Processor1(), p);
        h.process(new PostProsessor2HarnessAdaptor(), p);

    }

}
