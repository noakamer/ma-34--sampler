package ETL.Extract.Parse;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class CsvParser implements Parse {
    @Override
    public List<CSVRecord> parse(Object object) throws IOException {
        return ((CSVParser) object).getRecords();
    }
}
