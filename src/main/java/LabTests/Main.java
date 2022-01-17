package LabTests;

import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        LabTestsManager manager = new LabTestsManager();
        try {
            manager.manager("src/main/resources/LabTests.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
