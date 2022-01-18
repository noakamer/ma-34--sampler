package ETL.Transform.Split;

import java.util.ArrayList;
import java.util.List;

public class Split50000 implements SplitList {

    @Override
    public List<List<Object>> splitList(List list) {
        List<List<Object>> splitedList = new ArrayList<>();
        List<Object> current = new ArrayList<>();
        int i = 0;
        for (Object val : list) {
            if (i < 50000) {
                current.add(val);
            } else {
                splitedList.add(current);
                current.clear();
                i = 0;
            }
            i++;
        }
        if (i < 50000 && !current.isEmpty()) {
            splitedList.add(current);
        }
        return splitedList;
    }
}
