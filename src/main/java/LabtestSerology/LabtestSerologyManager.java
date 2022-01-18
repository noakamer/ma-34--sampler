package LabtestSerology;

import ETL.ETLManager;
import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Transform.CastCsvRecordListToStringList;
import com.google.common.io.Files;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LabtestSerologyManager extends ETLManager {

    public LabtestSerologyManager(){
        super();
    }

    public void manager(String path) throws IOException, InvalidIdException, JAXBException, SQLException, ClassNotFoundException {
        String type = Files.getFileExtension(path);
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        LabtestSerologyList labTestSerologyClass = new LabtestSerologyList();
        CheckAllRequirements checkAllRequirements = new CheckAllRequirements();
        WriteToSQL writeToSQL = new WriteToSQL();

        List<LabtestSerology> labTestSerologyList = labTestSerologyClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.get(type).parse(extract.get(type).read(path))));
        List<LabtestSerology> isOkToSend = new ArrayList<>();
        for (LabtestSerology current : labTestSerologyList) {
            if (checkAllRequirements.meetsRequirements(current)) {
                isOkToSend.add(current);
            }
        }
        writeToSQL.insertSql(isOkToSend);


    }
}
