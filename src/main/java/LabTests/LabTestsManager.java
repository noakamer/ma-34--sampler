package LabTests;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Load.JsonLoad;
import ETL.Load.Load;
import ETL.Load.XmlLoad;
import ETL.Transform.CastCsvRecordListToStringList;
import ETL.Transform.ChangePath;
import ETL.Transform.Split50000;
import MadaReports.MadaReports;
import MadaReports.MadaReportsList;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class LabTestsManager {

    public void manager (String path) throws IOException, InvalidIdException, JAXBException {
        Extract extract = new CsvExtract();
        Parse parse = new CsvParser();
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        LabTestsList labTestsListClass = new LabTestsList();
        Split50000 splitClass = new Split50000();
        Load load = new XmlLoad();
        ChangePath change = new ChangePath();


        List<LabTests> labTestsList = labTestsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(path))));
        List<List<String>> splitReports = splitClass.split50000(labTestsList);
        String basicPath = "src/main/resources/";
        for (List<String> list:splitReports) {
            basicPath = change.ChangePath(basicPath);
            load.load(basicPath,list);
        }
    }
}
