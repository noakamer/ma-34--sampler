package MadaReports;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Load.JsonLoad;
import ETL.Load.Load;
import ETL.Transform.CastCsvRecordListToStringList;
import ETL.Transform.ChangePath;
import ETL.Transform.Split50000;

import java.io.IOException;
import java.util.List;

public class MadaReportsManager {

    public void manager (String path) throws IOException {
        Extract extract = new CsvExtract();
        Parse parse = new CsvParser();
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        MadaReportsList madaReportsListClass = new MadaReportsList();
        Split50000 splitClass = new Split50000();
        Load load = new JsonLoad();
        ChangePath change = new ChangePath();

        List<MadaReports> madaReportsList = madaReportsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(path))));
        List<List<MadaReports>> splitReports = splitClass.split50000(madaReportsList);
        String basicPath = "C:\\Users\\kamer\\Desktop\\intellijProjects\\mada_reports\\";
        for (List<MadaReports> list:splitReports) {
            basicPath = change.ChangePath(basicPath);
            load.load(basicPath,list);
        }
    }

}
