import LabTests.LabTestsManager;
import LabtestSerology.LabtestSerologyManager;
import MadaReports.MadaReportsManager;
import PositiveCoronaPeople.PositiveCoronaPeopleManager;

public class Main {
    public static void main(String[] args) {
        PositiveCoronaPeopleManager p = new PositiveCoronaPeopleManager();
        MadaReportsManager madaReportsManager = new MadaReportsManager();
        LabtestSerologyManager m = new LabtestSerologyManager();
        LabTestsManager manager = new LabTestsManager();
    }
}
