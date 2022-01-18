package ETL;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Load.JsonLoad;
import ETL.Load.Load;
import ETL.Load.XmlLoad;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class ETLManager {
    protected Map<String, Extract> extract;
    protected Map<String, Parse> parse;
    protected Map<String, Load> load;

    public ETLManager(){
        this.extract = new HashMap<>();
        this.parse = new HashMap<>();
        this.load = new HashMap<>();
        addToHashMaps();
    }

    public void addToHashMaps(){
        extract.put("csv", new CsvExtract());
        parse.put("csv", new CsvParser());
        load.put("json", new JsonLoad());
        load.put("xml", new XmlLoad());
    }

    public abstract void manager(String path) throws IOException, InvalidIdException, JAXBException, SQLException, ClassNotFoundException;
}
