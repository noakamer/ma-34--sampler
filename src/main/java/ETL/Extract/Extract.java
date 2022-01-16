package ETL.Extract;

import java.io.IOException;

public interface Extract {

    public Object read(String path) throws IOException;
}
