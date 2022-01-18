package ETL.Transform;

import ETL.Load.Load;

import java.io.IOException;
import java.util.List;

public class SendToLoad <T> {
    ChangePath change = new ChangePath();
    public void send (List<List<T>> list, String basicPath, Load load) throws IOException {
        for (List<T> currentList : list) {
            basicPath = change.ChangePath(basicPath);
            load.load(basicPath, currentList);
        }
    }
}
