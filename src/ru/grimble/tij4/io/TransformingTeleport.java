package ru.grimble.tij4.io;

import java.io.*;

/**
 * Persistent name and varying appearence
 */
class Alien implements Externalizable {

    String name;
    String appearence= "Weired";

    public Alien() {}

    public Alien(String name) {
        this.name=name;
    }

    public void setAppearence(String appearence) {
        this.appearence=appearence;
    }

    @Override
    public String toString() {

        return String.format("%s alien %s",
                this.appearence.substring(0, 1).toUpperCase() + this.appearence.substring(1),
                name);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name= (String)in.readObject();
    }
}

/**
 * Object IO engine with on read transformation stub
 */
abstract class Teleport<T> {

    String portal;
    ObjectOutputStream out;
    ObjectInputStream in;

    public Teleport(String portal) {
        this.portal= portal;
    }

    public void send(T o) throws IOException {

        out= new ObjectOutputStream(new FileOutputStream(portal));

        System.out.println("Teleport opened");

        out.writeObject(o);

        System.out.format("%s has been teleported\n", o);

        out.close();

        System.out.println("Teleport closed");

    }

    public T receive() throws IOException, ClassNotFoundException {

        in= new ObjectInputStream(new FileInputStream(portal));

        System.out.println("Teleport opened");

        T o= (T)in.readObject();

        onReceive(o);

        System.out.format("%s came from teleport\n", o);

        in.close();

        System.out.println("Teleport closed");

        return o;
    }

    /**
     * Called after an object came in
     * @param o received object
     */
    abstract void onReceive(T o);
}

public class TransformingTeleport {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Creating an alien
        Alien sam= new Alien("Sam");

        // Making him ugly
        sam.setAppearence("ugly");

        System.out.format("Sam is %s\n", sam);

        // Creating teleport with nice transformation
        Teleport<Alien> niceAlienport= new Teleport<Alien>("nicifier.bin") {
            @Override
            void onReceive(Alien o) {
                o.setAppearence("nice");
            }
        };

        // Sending alien via teleport
        niceAlienport.send(sam);

        // Recieving alien from teleport
        sam= niceAlienport.receive();

        // Seeing what happened
        System.out.format("Sam is %s\n", sam);

    }
}
