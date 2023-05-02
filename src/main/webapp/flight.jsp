<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2023/05/02
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>flight-info</title>
</head>
<body>
<%
    String driverName = "com.mysql.cj.jdbc.Driver";
    String databaseURL = "jdbc:mysql://localhost/Module06";
    String username = "root";
    String userpwd = "7608";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    try {
        Class.forName(driverName);
        System.out.println("success");
    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        connection = DriverManager.getConnection(databaseURL, username, userpwd);


        String sql = "select * from passenger as p " +
                "inner join reservation as r on r.passengerno = p.passengerno " +
                "inner join flight as f on f.flightno = r.flightno " +
                "where p.passengerno=?";

        statement = connection.prepareStatement(sql);
        String passengerno = request.getParameter("id");
        statement.setInt(1,Integer.valueOf(passengerno));

        result = statement.executeQuery();

        %>
        <h1>예약정보</h1>
        <table border="1">
             <tr>
            <th>AircraftNo</th>
            <th>Depareture</th>
            <th>Arrival</th>
            <th>Price</th>
            <th>FlightDate</th>
            </tr>
            <%
        while(result.next()){
            int aircraftno = result.getInt(9);
            String departure = result.getString(10);
            String arrival = result.getString(11);
            int price = result.getInt(12);
            Date flightdate = result.getDate(13);
            %>

                <tr>
                    <td><p><%=aircraftno%></p></td>
                    <td><p><%=departure%></p></td>
                    <td><p><%=arrival%></p></td>
                    <td><p><%=price%></p></td>
                    <td><p><%=flightdate%></p></td>
                </tr>
            <%
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        result.close();
        statement.close();
        connection.close();
%>

</body>
</html>