package ETL.Transform.Split;

import ETL.Transform.HowManyBytesFromList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Split20Mb implements SplitList {

    @Override
    public List<List<Object>> splitList(List list) throws IOException {
        List<List<Object>> splitedList = new ArrayList<>();
        HowManyBytesFromList countMb = new HowManyBytesFromList();
        List<Object> current = new ArrayList<>();
        for (Object val : list) {
            if (countMb.getBytesFromList(current) < 20000000) {
                current.add(val);
            } else {
                splitedList.add(current);
                current.clear();
            }
        }
        if (!current.isEmpty()) {
            splitedList.add(current);
        }
        return splitedList;
    }
}
