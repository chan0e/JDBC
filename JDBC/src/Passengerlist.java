import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Passengerlist {
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String databaseURL = "jdbc:mysql://localhost/TEST";
    private static final String userNmae = "root";
    private static final String userpwd = "7608";

    private List<Passenger> list = new ArrayList<>();

    public void load() {

        try {
            Class.forName(driverName);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<Passenger> getData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(databaseURL, userNmae, userpwd);
            statement = connection.createStatement();

            String sql = "select * from passenger";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                this.list.add(new Passenger(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4))
                );

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return this.list;
    }
}
