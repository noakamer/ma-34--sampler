package ETL.Transform;

import PositiveCoronaPeople.PositiveCoronaPeople;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class HowManyBytesFromList<T> {

    public long getBytesFromList(List<T> list) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(list);
        out.close();
        return baos.toByteArray().length;
    }
}
