import ETL.ETLManager;
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
        ETLManager madaReportsManager = new MadaReportsManager();
        ETLManager labtestSerologyManager = new LabtestSerologyManager();
        ETLManager labTestsManager = new LabTestsManager();
        try {
            labTestsManager.manager("src/main/resources/LabTests.csv");
            labtestSerologyManager.manager("src/main/resources/Serology.csv");
            madaReportsManager.manager("src/main/resources/MadaReports.csv");
            positiveCoronaPeopleManager.manager();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
    }
}
