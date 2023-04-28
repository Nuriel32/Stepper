package mta.course.java.stepper.xmlparse.mta.course.java.stepper.xmlparse;

import mta.course.java.stepper.xmlparse.STFlows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SchemaBaesdJAXCreator {
    private final static String JAXB_XML_GAME_PACKAGE_NAME = "E:\\JAVA ACA\\Project\\stepper-design-suggestion-master\\stepper-engine\\src\\mta\\course\\java\\stepper\\xmlparse\\mta\\course\\java\\stepper\\xmlparse";

    public static void Loader() {
        try {
            InputStream inputStream = new FileInputStream(new File("src/resources/ex1.xml"));
            STFlows countries = deserializeFrom(inputStream);
           // System.out.println("name of first country is: " + countries.().get(0).getName());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static STFlows deserializeFrom(InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (STFlows) u.unmarshal(in);
    }
}
}