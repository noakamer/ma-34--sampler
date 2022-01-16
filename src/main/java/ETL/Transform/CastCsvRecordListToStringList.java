package ETL.Transform;

import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class CastCsvRecordListToStringList {

    public List<String> CsvRecordToString(List<CSVRecord> recordList) {
        List<String> stringList = new ArrayList<>();
        String str = "";
        for (CSVRecord record : recordList) {
            for (int i = 0; i < record.size(); i++) {
                str += record.get(i) + ",";
            }
            str = str.substring(0, str.length() - 1);
            stringList.add(str);
            str = "";
        }
        return stringList;
    }
}
