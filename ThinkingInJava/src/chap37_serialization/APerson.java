package chap37_serialization;

// Use the XOM library to write and read XML
// nu.xom.Node comes from http://www.xom.nu

import nu.xom.*;

import java.io.*;
import java.util.*;

public class APerson {
    private String first, last;

    public APerson(String first, String last) {
        this.first = first;
        this.last = last;
    }

    // Produce an XML Element from this APerson object:
    public Element getXML() {
        Element person = new Element("person");

        Element firstName = new Element("first");
        firstName.appendChild(first);

        Element lastName = new Element("last");
        lastName.appendChild(last);

        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    // Constructor restores a APerson from XML:
    public APerson(Element person) {
        first = person
                .getFirstChildElement("first").getValue();
        last = person
                .getFirstChildElement("last").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    // Make it human-readable: 好! 真TM好! 太TM好了!
    public static void format(OutputStream os, Document doc)
            throws Exception {
        Serializer serializer =
                new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<APerson> people = Arrays.asList(
                new APerson("Dr. Bunsen", "Honeydew"),
                new APerson("Gonzo", "The Great"),
                new APerson("Phillip J.", "Fry"));
        System.out.println(people);
        Element root = new Element("people");

        for (APerson p : people)
            root.appendChild(p.getXML());

        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(
                new FileOutputStream("ThinkingInJava/src/" +
                        "chap37_serialization/People.xml")), doc);
    }
}
