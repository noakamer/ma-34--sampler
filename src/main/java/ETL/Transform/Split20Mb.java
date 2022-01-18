package ETL.Transform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Split20Mb <T> {

    public List<List<T>> split20Mb(List<T> list) throws IOException {
        List<List<T>> splitedList = new ArrayList<>();
        HowManyBytesFromList countMb = new HowManyBytesFromList();
        List<T> current = new ArrayList<>();
        for (T val : list) {
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
