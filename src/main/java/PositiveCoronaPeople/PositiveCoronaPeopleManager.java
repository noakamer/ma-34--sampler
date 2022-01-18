package PositiveCoronaPeople;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Load.JsonLoad;
import ETL.Load.Load;
import ETL.Transform.*;
import ETL.Transform.Split.Split20Mb;
import ETL.Transform.Split.SplitList;
import LabTests.LabTests;
import MadaReports.MadaReports;
import MadaReports.MadaReportsList;
import health_care_provider.errors.InvalidIdException;
import LabTests.LabTestsList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PositiveCoronaPeopleManager {
    private Load load;
    private ChangePath change;
    private Extract extract;
    private Parse parse;
    private CastCsvRecordListToStringList castToStringList;
    private StringListToObjectList madaReportsListClass;
    private StringListToObjectList labTestsListClass;

    public PositiveCoronaPeopleManager(){
        this.load = new JsonLoad();
        this.change = new ChangePath();
        this.extract = new CsvExtract();
        this.parse = new CsvParser();
        this.castToStringList = new CastCsvRecordListToStringList();
        this.madaReportsListClass = new MadaReportsList();
        this.labTestsListClass = new LabTestsList();
    }

    public void manager() throws IOException, InvalidIdException {
        String madaRecordPath = "src/main/resources/MadaReports.csv";
        String labTestsPath = "src/main/resources/LabTests.csv";
        List<MadaReports> madaReportsList = madaReportsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(madaRecordPath))));
        List<LabTests> labTestsList = labTestsListClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(labTestsPath))));
        List<PositiveCoronaPeople> coronaPeopleList = new ArrayList<>();
        for (LabTests labTest : labTestsList) {
            if (labTest.getResultTestCorona() == 1) {
                for (MadaReports madaReport : madaReportsList) {
                    if (labTest.getIDNum() == madaReport.getIDNum()) {
                        coronaPeopleList.add(new PositiveCoronaPeople(madaReport.getIDNum(), madaReport.getIDType(),
                                madaReport.getFirstName(), madaReport.getLastName(), madaReport.getCity(),
                                madaReport.getStreet(), madaReport.getBuildingNumber(), madaReport.getBarcode(),
                                labTest.getBirthDate(), labTest.getLabCode(), labTest.getResultDate(),
                                madaReport.getTakeDate(), labTest.getStickerNumber(), labTest.getResultTestCorona(),
                                labTest.getVariant(), labTest.getTestType()));
                    }
                }
            }
        }

        String basicPath = "C:\\Users\\kamer\\Desktop\\intellijProjects\\POSITIVE_CORONA_PEOPLE\\";
        SplitList split20Mb = new Split20Mb();
        List<List<PositiveCoronaPeople>> split20mb = split20Mb.splitList(coronaPeopleList);
        for (List<PositiveCoronaPeople> list : split20mb) {
            basicPath = change.ChangePath(basicPath);
            load.load(basicPath, list);
        }
    }
}
