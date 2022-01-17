package MadaReports;

import java.util.ArrayList;
import java.util.List;

public class MadaReportsList {

    public List<MadaReports> StringListToMadaReportsList(List<String> stringList) {
        List<MadaReports> madaReportsList = new ArrayList<>();
        for (String str : stringList) {
            if (!str.equals(stringList.get(0)))
                madaReportsList.add(new MadaReports(str));
        }
        return madaReportsList;
    }
}
