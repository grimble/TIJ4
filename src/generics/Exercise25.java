package generics;

interface BrickLayer { void lay(); }

interface Mortarer { void mix(); }

class Mason implements BrickLayer, Mortarer {
    public Mason() { System.out.println("New mason created"); }
    public void lay() { System.out.println("Mason is laying bricks"); }
    public void mix() { System.out.println("Mason is mixing mortar"); }
}

public class Exercise25 {
    
    static <BL extends BrickLayer> void lay(BL bl) { 
        System.out.println("Asking bricklayer to lay");
        bl.lay(); 
    }

    static <MR extends Mortarer> void mix(MR mr) { 
        System.out.println("Asking mortarer to mix");
        mr.mix(); 
    }
    
    public static void main(String []args) {
        System.out.println("Hello World");
        Mason mn= new Mason();
        lay(mn);
        mix(mn);
    }
}
