package com.academy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBcodes {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String databaseURL = "jdbc:mysql://localhost/Module06";
    private String username = "root";
    private String userpwd = "7608";

    List<Passenger> passengerList = new ArrayList<>();



    public void load() {
        try {
            Class.forName(driverName);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Passenger> getdata() {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = DriverManager.getConnection(databaseURL, username, userpwd);
            statement = connection.createStatement();
            String sql = "select * from passenger";

            result = statement.executeQuery(sql);

            while (result.next()){
                this.passengerList.add(new Passenger(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4)
                ));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return this.passengerList;
    }


}