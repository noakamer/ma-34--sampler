package LabTests;

import ETL.Transform.StringListToObjectList;

import java.util.ArrayList;
import java.util.List;

public class LabTestsList implements StringListToObjectList {

    @Override
    public List stringListToObjectList(List list) {
        List<LabTests> labTestsList = new ArrayList<>();
        for (String str : (List<String>) list) {
            if (!str.equals(list.get(0)))
                labTestsList.add(new LabTests(str));
        }
        return labTestsList;
    }
}
