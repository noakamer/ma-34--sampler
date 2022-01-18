import LabTests.LabTestsManager;
import LabtestSerology.LabtestSerologyManager;
import MadaReports.MadaReportsManager;
import PositiveCoronaPeople.PositiveCoronaPeopleManager;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        PositiveCoronaPeopleManager positiveCoronaPeopleManager = new PositiveCoronaPeopleManager();
        MadaReportsManager madaReportsManager = new MadaReportsManager();
        LabtestSerologyManager labtestSerologyManager = new LabtestSerologyManager();
        LabTestsManager labTestsManager = new LabTestsManager();
        try {
            positiveCoronaPeopleManager.manager();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        try {
            madaReportsManager.manager("src/main/resources/MadaReports.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            labtestSerologyManager.manager("src/main/resources/Serology.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            labTestsManager.manager("src/main/resources/LabTests.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
