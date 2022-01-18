import LabTests.LabTestsManager;
import LabtestSerology.LabtestSerologyManager;
import MadaReports.MadaReportsManager;
import PositiveCoronaPeople.PositiveCoronaPeopleManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PositiveCoronaPeopleManager positiveCoronaPeopleManager = new PositiveCoronaPeopleManager();
        MadaReportsManager madaReportsManager = new MadaReportsManager();
        LabtestSerologyManager labtestSerologyManager = new LabtestSerologyManager();
        LabTestsManager labTestsManager = new LabTestsManager();

        try {
            labTestsManager.manager("src/main/resources/LabTests.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
