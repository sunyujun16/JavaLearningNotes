package chap37_serialization;

// nu.xom.Node comes from http://www.xom.nu
// {RunFirst: APerson}

import nu.xom.*;

import java.io.File;
import java.util.*;

public class People extends ArrayList<APerson> {
    public People(String fileName) throws Exception {
        Document doc =
                new Builder().build(new File(fileName));
        Elements elements =
                doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++)
            add(new APerson(elements.get(i)));
    }

    public static void main(String[] args) throws Exception {
        People p = new People("ThinkingInJava/src/" +
                "chap37_serialization/People.xml");
        System.out.println(p);
    }
}
