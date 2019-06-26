package ru.grimble.tij4.xml;

import nu.xom.Document;
import nu.xom.Element;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

class Person extends xml.Person {

    private String address;

    public Person() {
        this("", "", "");
    }

    public Person(String first, String last) {
        this(first, last, "");
    }

    public Person(String first, String last, String address) {
        super(first, last);
        this.address= address;
    }

    @Override
    public Element getXML() {
        Element person= super.getXML();
        Element address= new Element("address");
        address.appendChild(this.address);
        person.appendChild(address);
        return person;
    }

    public Person(Element person) {
        super(person);
        address = person.getFirstChildElement("address").getValue();
    }

    @Override
    public String toString() {
        return super.toString() + " @ " + address;
    }
}

public class Exercise31 {
    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "Ivory st. 25"),
                new Person("Gonzo", "The Great", "Mellow bvd. 6"),
                new Person("Phillip J.", "Fry", "Ginger av. 17"));
        System.out.println(people);
        Element root = new Element("people");
        for(Person p : people)
            root.appendChild(p.getXML());
        Document doc = new Document(root);
        Person.format(System.out, doc);
        Person.format(new BufferedOutputStream(new FileOutputStream(
                "People.xml")), doc);
    }

}
