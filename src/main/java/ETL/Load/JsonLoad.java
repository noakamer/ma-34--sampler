package ETL.Load;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonLoad implements Load{
    private ObjectMapper mapper;

    public JsonLoad(){
        mapper=new ObjectMapper();
    }
    
    @Override
    public void load(String path, List list) throws IOException {
        mapper.writeValue(new File(path),list);
    }
}
