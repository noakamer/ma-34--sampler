package MadaReports;

import ETL.ETLManager;
import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Load.JsonLoad;
import ETL.Load.Load;
import ETL.Transform.CastCsvRecordListToStringList;
import ETL.Transform.ChangePath;
import ETL.Transform.Split.Split50000;
import ETL.Transform.Split.SplitList;
import com.google.common.io.Files;

import java.io.IOException;
import java.util.List;

public class MadaReportsManager extends ETLManager {

    public MadaReportsManager(){
        super();
    }

    public void manager(String path) throws IOException {
        String type = Files.getFileExtension(path);
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        MadaReportsList madaReportsListClass = new MadaReportsList();
        ChangePath change = new ChangePath();
        SplitList split50000 = new Split50000();

        List<MadaReports> madaReportsList = madaReportsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.get(type).parse(extract.get(type).read(path))));
        List<List<MadaReports>> splitReports = split50000.splitList(madaReportsList);
        String basicPath = "C:\\Users\\kamer\\Desktop\\intellijProjects\\mada_reports\\";
        for (List<MadaReports> list : splitReports) {
            basicPath = change.ChangePath(basicPath);
            load.get("json").load(basicPath, list);
        }
    }

}
