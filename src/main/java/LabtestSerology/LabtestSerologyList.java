package LabtestSerology;

import ETL.Transform.StringListToObjectList;

import java.util.ArrayList;
import java.util.List;

public class LabtestSerologyList implements StringListToObjectList {
    @Override
    public List stringListToObjectList(List list) {
        List<LabtestSerology> labTestsList = new ArrayList<>();
        for (String str : (List<String>) list) {
            if (!str.equals(list.get(0)))
                labTestsList.add(new LabtestSerology(str));
        }
        return labTestsList;
    }
}
