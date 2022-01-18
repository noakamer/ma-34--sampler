package MadaReports;

import ETL.ETLManager;
import ETL.Transform.CastCsvRecordListToStringList;
import ETL.Transform.SendToLoad;
import ETL.Transform.Split.Split50000;
import ETL.Transform.Split.SplitList;
import com.google.common.io.Files;

import java.io.IOException;
import java.util.List;

public class MadaReportsManager extends ETLManager {
    private CastCsvRecordListToStringList castToStringList;
    private MadaReportsList madaReportsListClass;
    private SendToLoad send;
    private SplitList split50000;

    public MadaReportsManager() {
        super();
        this.castToStringList = new CastCsvRecordListToStringList();
        this.madaReportsListClass = new MadaReportsList();
        this.send = new SendToLoad();
        this.split50000 = new Split50000();
    }

    public void manager(String path) throws IOException {
        String type = Files.getFileExtension(path);
        List<MadaReports> madaReportsList = madaReportsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.get(type).parse(extract.get(type).read(path))));
        List<List<MadaReports>> splitReports = split50000.splitList(madaReportsList);
        String basicPath = "C:\\Users\\kamer\\Desktop\\intellijProjects\\mada_reports\\";
        send.send(splitReports, basicPath, load.get("json"));
    }

}
