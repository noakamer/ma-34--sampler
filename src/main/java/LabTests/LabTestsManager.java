package LabTests;

import ETL.ETLManager;
import ETL.Transform.CastCsvRecordListToStringList;
import ETL.Transform.SendToLoad;
import ETL.Transform.Split.Split50000;
import ETL.Transform.Split.SplitList;
import com.google.common.io.Files;

import java.io.IOException;
import java.util.List;

public class LabTestsManager extends ETLManager {
    private CastCsvRecordListToStringList castToStringList;
    private LabTestsList labTestsListClass;
    private SplitList split50000;
    private SendToLoad send;

    public LabTestsManager() {
        super();
        this.castToStringList = new CastCsvRecordListToStringList();
        this.labTestsListClass = new LabTestsList();
        this.split50000 = new Split50000();
        this.send = new SendToLoad();
    }

    public void manager(String path) throws IOException {
        String type = Files.getFileExtension(path);
        List<LabTests> labTestsList = labTestsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.get(type).parse(extract.get(type).read(path))));
        List<List<String>> splitReports = split50000.splitList(labTestsList);
        String basicPath = "C:\\Users\\kamer\\Desktop\\intellijProjects\\LABTESTS\\";
        send.send(splitReports, basicPath, load.get("xml"));
    }
}
