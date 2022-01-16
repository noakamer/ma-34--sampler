package ETL.Extract;

import java.io.IOException;
import java.util.List;

public interface Parse <T>{

    public List<T> parse (Object object) throws IOException;
}
