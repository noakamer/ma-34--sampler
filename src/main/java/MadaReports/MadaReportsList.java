package MadaReports;

import ETL.Transform.StringListToObjectList;

import java.util.ArrayList;
import java.util.List;

public class MadaReportsList implements StringListToObjectList {

    @Override
    public List<MadaReports> stringListToObjectList(List list) {
        List<MadaReports> madaReportsList = new ArrayList<>();
        for (String str : (List<String>) list) {
            if (!str.equals(list.get(0)))
                madaReportsList.add(new MadaReports(str));
        }
        return madaReportsList;
    }
}
