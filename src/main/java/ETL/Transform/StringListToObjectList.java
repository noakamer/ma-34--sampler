package ETL.Transform;

import MadaReports.MadaReports;

import java.util.List;

public interface StringListToObjectList <T>{

    public List<T> stringListToObjectList(List<String> stringList);
}
