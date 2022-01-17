package PositiveCoronaPeople;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Transform.CastCsvRecordListToStringList;
import ETL.Transform.StringListToObjectList;
import LabTests.LabTests;
import MadaReports.MadaReports;
import MadaReports.MadaReportsList;
import health_care_provider.errors.InvalidIdException;
import LabTests.LabTestsList;
import LabTests.LabTests;
import java.io.IOException;
import java.util.List;

public class PositiveCoronaPeopleManager {

    public void ma () throws IOException, InvalidIdException {
        Extract extract = new CsvExtract();
        Parse parse = new CsvParser();
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        StringListToObjectList madaReportsListClass = new MadaReportsList();
        StringListToObjectList labTestsListClass = new LabTestsList();
        String madaRecordPath = "src/main/resources/MadaReports.csv";
        String labTestsPath = "src/main/resources/LabTests.csv";
        List<MadaReports> madaReportsList = madaReportsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(madaRecordPath))));
        List<LabTests> labTestsList = labTestsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(labTestsPath))));
        for (LabTests labTest:labTestsList) {

        }
    }
}
