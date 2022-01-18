package LabtestSerology;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Transform.CastCsvRecordListToStringList;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LabtestSerologyManager {

    public void manager(String path) throws IOException, InvalidIdException, JAXBException, SQLException, ClassNotFoundException {
        Extract extract = new CsvExtract();
        Parse parse = new CsvParser();
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        LabtestSerologyList labTestSerologyClass = new LabtestSerologyList();
        CheckAllRequirements checkAllRequirements = new CheckAllRequirements();
        WriteToSQL writeToSQL = new WriteToSQL();

        List<LabtestSerology> labTestSerologyList = labTestSerologyClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(path))));
        List<LabtestSerology> isOkToSend = new ArrayList<>();
        for (LabtestSerology current : labTestSerologyList) {
            if (checkAllRequirements.meetsRequirements(current)) {
                isOkToSend.add(current);
            }
        }
        writeToSQL.insertSql(isOkToSend);


    }
}
