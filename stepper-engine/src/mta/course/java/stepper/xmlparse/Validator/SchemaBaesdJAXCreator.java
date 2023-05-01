package mta.course.java.stepper.xmlparse.Validator;

import jdk.internal.org.xml.sax.SAXException;
import mta.course.java.stepper.xmlparse.STFlows;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class SchemaBaesdJAXCreator {
    private final static String JAXB_XML_GAME_PACKAGE_NAME = "mta.course.java.stepper.xmlparse";

    public static void Loader() {
        try {
            InputStream inputStream = SchemaBaesdJAXCreator.class.getClassLoader().getResourceAsStream("ex1.xml");
            if (inputStream == null) {
                throw new FileNotFoundException("XML file not found");
            }
            STFlows stFlows = deserializeFrom(inputStream);
            // Perform any additional processing with the stFlows object here
        } catch (JAXBException | SAXException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static STFlows deserializeFrom(InputStream in) throws JAXBException, SAXException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();

        // Load the schema as a resource
        URL schemaResource = SchemaBaesdJAXCreator.class.getClassLoader().getResource("schema.xsd");
        if (schemaResource == null) {
            try {
                throw new FileNotFoundException("Schema file not found");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // Set the schema for the unmarshaller
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = sf.newSchema(schemaResource);
        } catch (org.xml.sax.SAXException e) {
            throw new RuntimeException(e);
        }
        u.setSchema(schema);

        return (STFlows) u.unmarshal(in);
    }
}
