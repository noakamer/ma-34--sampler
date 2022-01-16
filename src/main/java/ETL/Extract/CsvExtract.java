package ETL.Extract;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class CsvExtract implements Extract{


    @Override
    public Object read(String path) throws IOException{
        return new CSVParser(new FileReader(path), CSVFormat.RFC4180);
    }
}
