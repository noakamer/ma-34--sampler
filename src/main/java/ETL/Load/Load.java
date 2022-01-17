package ETL.Load;

import java.io.IOException;
import java.util.List;

public interface Load<T> {

    public void load(String path, List<T> list) throws IOException;
}
