package ETL.Transform;

import health_care_provider.errors.InvalidIdException;

import java.util.List;

public interface StringListToObjectList<T> {

    public List<T> stringListToObjectList(List<String> stringList) throws InvalidIdException;
}
