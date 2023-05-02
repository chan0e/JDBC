import java.sql.Statement;

import com.mysql.cj.PreparedQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FirstConnection {


    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String databaseURL = "jdbc:mysql://localhost/TEST";
    private static final String userNmae = "root";
    private static final String userpwd = "7608";

    // private static final String driverName = "oracle.jdbc.driver.OracleDriver";
    // private static final String databaseURL = "jdbc:oracle:thin:@10.220.222.100:1521:xe";
    // private static final String userNmae = "scott";
    // private static final String userpwd = "tiger";

    Connection connection = null;
    // Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement statement = null;


    public void connect() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(databaseURL, userNmae, userpwd);
            // statement = connection.createStatement();


            String sqlQuery = "select * from flight where aircraftno=?";

            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, 105);


            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + " ");
                System.out.print(resultSet.getInt(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getString(4) + " ");

                System.out.println();

            }
            resultSet.close();
            connection.close();
            resultSet.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new FirstConnection().connect();
    }

}
