package ru.grimble.tij4.io;

import java.io.*;

/**
 * Persistent name and varying appearence
 */
class Alien implements Externalizable {

    String name;
    String appearence;

    public Alien() {}

    public Alien(String name) {
        this.name=name;
    }

    public void setAppearence(String appearence) {
        this.appearence=appearence;
    }

    @Override
    public String toString() {

        String appearence;

        if (this.appearence == null)
            appearence= "";
        else
            appearence= this.appearence;

        if (appearence.length() == 0)
            appearence= "Weired";
        else
            appearence= appearence.substring(0, 1).toUpperCase() + appearence.substring(1);

        return String.format("%s alien %s", appearence, name);
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
abstract class Teleport {

    String portal;
    ObjectOutputStream out;
    ObjectInputStream in;

    public Teleport(String portal) {
        this.portal=portal;
    }

    public void send(Object o) throws IOException {

        out= new ObjectOutputStream(new FileOutputStream(portal));

        System.out.println("Teleport opened");

        out.writeObject(o);

        System.out.format("%s has been teleported\n", o);

        out.close();

        System.out.println("Teleport closed");

    }

    public Object recieve() throws IOException, ClassNotFoundException {

        in= new ObjectInputStream(new FileInputStream(portal));

        System.out.println("Teleport opened");

        Object o= (Alien)in.readObject();

        onRecieve(o);

        System.out.format("%s came from teleport\n", o);

        in.close();

        System.out.println("Teleport closed");

        return o;
    }

    /**
     * Called after an object came in
     * @param o received object
     */
    abstract void onRecieve(Object o);
}

public class TransformingTeleport {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Creating an alien
        Alien sam= new Alien("Sam");

        // Making him ugly
        sam.setAppearence("ugly");

        System.out.format("Sam is %s\n", sam);

        // Creating teleport with nice transformation
        Teleport niceTeleport= new Teleport("nicifier.bin") {
            @Override
            void onRecieve(Object o) {
                ((Alien)o).setAppearence("nice");
            }
        };

        // Sending alien via teleport
        niceTeleport.send(sam);

        // Recieving alien from teleport
        sam= (Alien)niceTeleport.recieve();

        // Seeing what happened
        System.out.format("Sam is %s\n", sam);

    }
}
