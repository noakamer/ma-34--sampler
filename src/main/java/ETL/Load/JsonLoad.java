package ETL.Load;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonLoad implements Load {
    private ObjectMapper mapper;

    public JsonLoad() {
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Override
    public void load(String path, List list) throws IOException {
        mapper.writeValue(new File(path+".json"), list);
    }
}
