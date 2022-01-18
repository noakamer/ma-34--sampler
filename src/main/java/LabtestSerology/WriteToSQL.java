package LabtestSerology;

import java.sql.*;
import java.util.List;

public class WriteToSQL {

    public void insertSql(List<LabtestSerology> isOkToSend) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LabResults;integratedSecurity=true;");
        Statement statement = connection.createStatement();

        PreparedStatement preparedStmt;
        for (LabtestSerology current : isOkToSend) {
            String query = " insert into LabResults_SerologyKits (IDNum, IDType, FirstName, LastName, ResultDate, BirthDate," +
                    "LabCode, StickerNumber, Antidotes, KitNumber)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStmt = connection.prepareStatement(query);
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

            preparedStmt.execute();
        }

        statement.close();
        connection.close();
    }
}
