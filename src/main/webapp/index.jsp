<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> 승객 목록
</h1>
<br/>
<%
    String driverName = "com.mysql.cj.jdbc.Driver";
    String databaseURL = "jdbc:mysql://localhost/Module06";
    String username = "root";
    String userpwd = "7608";

    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;

    try {
        Class.forName(driverName);
        System.out.println("success");
    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        connection = DriverManager.getConnection(databaseURL, username, userpwd);
        statement = connection.createStatement();
        String sql = "select * from passenger";

        result = statement.executeQuery(sql);

        int passengerno = 0;
        String passengername = null;
        String grade = null;
        int Age = 0;

        %>

    <table border="1">
    <tr>
        <th>Passenger Name</th>
        <th>Grade</th>
        <th>Age</th>
    </tr>

        <%
        while(result.next()){

            passengerno = result.getInt(1);
            passengername = result.getString(2);
            grade = result.getString(3);
            Age = result.getInt(4);
        %>

            <tr>
                <td><p> <a href="flight.jsp?id=<%=passengerno%>"> <%=passengername%></a> </p></td>
                <td><p> <%=grade%> </p> </td>
                <td><p> <%=Age%> </p> </td>
            </tr>
            <%
        }
        %>
    </table>

        <%
        result.close();
        statement.close();
        connection.close();


    } catch (SQLException e) {
        e.printStackTrace();
    }

    %>
</body>
</html>