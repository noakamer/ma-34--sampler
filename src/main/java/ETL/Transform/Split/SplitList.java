package ETL.Transform.Split;

import java.io.IOException;
import java.util.List;

public interface SplitList<T> {
    public List<List<T>> splitList(List<T> list) throws IOException;
}
