package ETL.Transform;

import java.util.ArrayList;
import java.util.List;

public class Split50000<T> {
    
    public List<List<T>> split50000(List<T> list) {
        List<List<T>> splitedList = new ArrayList<>();
        List<T> current = new ArrayList<>();
        int i = 0;
        for (T val : list) {
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
