package ETL;

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

public abstract class ETLManager {
    protected Extract extract;
    protected Parse parse;
    protected CastCsvRecordListToStringList castToStringList;
    protected Split50000 splitClass;
    protected Load load;
    protected ChangePath change;

    public ETLManager() {
        extract = new CsvExtract();
        parse = new CsvParser();
        castToStringList = new CastCsvRecordListToStringList();
        splitClass = new Split50000();
        load = new JsonLoad();
        change = new ChangePath();
    }

    public abstract void manager(String path) throws IOException;
}
