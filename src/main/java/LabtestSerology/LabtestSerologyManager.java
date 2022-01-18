package LabtestSerology;

import ETL.Extract.CsvExtract;
import ETL.Extract.Extract;
import ETL.Extract.Parse.CsvParser;
import ETL.Extract.Parse.Parse;
import ETL.Transform.CastCsvRecordListToStringList;
import health_care_provider.errors.InvalidIdException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LabtestSerologyManager {

    public void manager(String path) throws IOException, InvalidIdException, JAXBException {
        Extract extract = new CsvExtract();
        Parse parse = new CsvParser();
        CastCsvRecordListToStringList castToStringList = new CastCsvRecordListToStringList();
        LabtestSerologyList labTestSerologyClass = new LabtestSerologyList();
        CheckAllRequirements checkAllRequirements = new CheckAllRequirements();

        List<LabtestSerology> labTestSerologyList = labTestSerologyClass.stringListToObjectList(castToStringList.CsvRecordToString(parse.parse(extract.read(path))));
        List<LabtestSerology> isOkToSend = new ArrayList<>();
        for (LabtestSerology current : labTestSerologyList) {
            if (checkAllRequirements.meetsRequirements(current)) {
                isOkToSend.add(current);
            }
        }
        System.out.println(isOkToSend.size());

        //send to sql


        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost:1433";

        try (Connection con = DriverManager.getConnection(connectionUrl, "dbo", "123"); Statement stmt = con.createStatement();) {

            PreparedStatement preparedStmt;
            for (LabtestSerology current : isOkToSend) {
                String query = " insert into LabResults_SerologyKits (IDNum, IDType, FirstName, LastName, ResultDate, BirthDate," +
                        "LabCode, StickerNumber, Antidotes, KitNumber)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, current.getIDNum());
                preparedStmt.setInt(2, current.getIDType());
                preparedStmt.setString(3, current.getFirstName());
                preparedStmt.setString(4, current.getLastName());
                preparedStmt.setString(5, current.getResultDate());
                preparedStmt.setString(6, current.getBirthDate());
                preparedStmt.setString(7, current.getLabCode());
                preparedStmt.setString(8, current.getStickerNumber());
                preparedStmt.setInt(9, current.getAntidotes());
                preparedStmt.setInt(10, current.getKitNumber());

                // execute the preparedstatement
                preparedStmt.execute();
            }

            ResultSet rs = stmt.executeQuery("SELECT * FROM LabResults_SerologyKits");
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
