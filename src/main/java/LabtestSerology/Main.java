package LabtestSerology;

import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LabtestSerologyManager m = new LabtestSerologyManager();
        try {
            m.manager("src/main/resources/Serology.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
