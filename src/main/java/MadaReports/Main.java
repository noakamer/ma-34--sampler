package MadaReports;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MadaReportsManager madaReportsManager = new MadaReportsManager();
        try {
            madaReportsManager.manager("src/main/resources/MadaReports.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
