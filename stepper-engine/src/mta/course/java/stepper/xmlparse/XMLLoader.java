package mta.course.java.stepper.xmlparse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XMLLoader {

    private String log;
    private File xmlFile;
    STStepper stStepper;
    public XMLLoader(String xmlFilePath) {
        xmlFile = new File(xmlFilePath);

    }

    public STStepper load() {
        try {
            if (!validateXML()) {
                log += "XML file is not valid according to the schema.\n";
                return null;
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(STStepper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            STStepper stStepper = (STStepper) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(stStepper);
            this.stStepper = stStepper;
            return stStepper;

        } catch (JAXBException e) {
            log += "JAXBException occurred: " + e.getMessage() + "\n";
            e.printStackTrace();
            return null;
        }
    }

    private boolean validateXML() {
        try {
            String schemaContent = loadSchemaContent();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(new StringReader(schemaContent)));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            return true;
        } catch (Exception e) {
            log += "Validation exception occurred: " + e.getMessage() + "\n";
            e.printStackTrace();
            return false;
        }
    }

    private String loadSchemaContent() throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream("/resources/Stepper-V1.xsd")) {
            if (inputStream == null) {
                throw new IOException("Schema file not found");
            }
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
                return scanner.useDelimiter("\\A").next();
            }
        }
    }

    public boolean validateSTFlowNames() {
        boolean isValid = true;
        Set<String> flowNames = new HashSet<>();

        for (STFlow stFlow : stStepper.getStFlows().getStFlow()) {
            String flowName = stFlow.getName();

            if (flowNames.contains(flowName)) {
                log += "Duplicate STFlow name found: " + flowName + ". Flow names should be unique.\n";
                isValid = false;
            } else {
                flowNames.add(flowName);
            }
        }

        return isValid;
    }
    public String getLog() {
        return log;
    }
}

