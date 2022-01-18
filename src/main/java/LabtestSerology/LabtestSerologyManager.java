package LabtestSerology;

import ETL.ETLManager;
import ETL.Transform.CastCsvRecordListToStringList;
import com.google.common.io.Files;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LabtestSerologyManager extends ETLManager {

    private CastCsvRecordListToStringList castToStringList;
    private LabtestSerologyList labTestSerologyClass;
    private CheckAllRequirements checkAllRequirements;
    private WriteToSQL writeToSQL;

    public LabtestSerologyManager() {
        super();
        this.castToStringList = new CastCsvRecordListToStringList();
        this.labTestSerologyClass = new LabtestSerologyList();
        this.checkAllRequirements = new CheckAllRequirements();
        this.writeToSQL = new WriteToSQL();
    }

    public void manager(String path) throws IOException, InvalidIdException, JAXBException, SQLException, ClassNotFoundException {
        String type = Files.getFileExtension(path);

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
