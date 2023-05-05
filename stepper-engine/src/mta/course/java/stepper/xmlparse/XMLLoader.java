package mta.course.java.stepper.xmlparse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLLoader {
    private String log = "";
    private String filePath;

    public XMLLoader(String filePath) {
        this.filePath = filePath;
    }/**
     * The XMLLoader class is responsible for loading XML files and deserializing
     * the content into an STStepper object.
     * <p>
     * It contains a log data member that stores any exceptions that might occur
     * during the loading process.
     * <p>
     * Example usage:
     * <pre>
     *     XMLLoader xmlLoader = new XMLLoader("C:\\Steptocheck\\ex1.xml");
     *     STStepper stStepper = xmlLoader.load();
     *     if (stStepper == null) {
     *         System.out.println("Failed to load STStepper. Log: \n" + xmlLoader.getLog());
     *     } else {
     *         System.out.println("STStepper loaded successfully.");
     *     }
     * </pre>
     */
    public STStepper load() {
        STStepper stStepper = null;

        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(STStepper.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            stStepper = (STStepper) jaxbUnmarshaller.unmarshal(file);
            System.out.println(stStepper);

        } catch (JAXBException e) {
            log += "JAXBException: " + e.getMessage() + "\n";
            e.printStackTrace();
        }

        return stStepper;
    }

    public String getLog() {
        return log;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
