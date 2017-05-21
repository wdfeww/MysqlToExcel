/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltoexcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wdfeww
 */
public class ConnectionProvider {
    
    private final String URL = "jdbc:mysql://localhost/";
    private final String DBNAME = "world";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
     private Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection conn = null;
        try {

            Class.forName(DRIVER).newInstance();
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return conn;
    }
     
     public List<City> getAllCities() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<City> clients = new ArrayList<>();
        String query = "SELECT * FROM City";
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (conn != null) {
                while (rs.next()) {
                    
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    String countryCode = rs.getString("CountryCode");
                    String district = rs.getString("District");
                    long population = rs.getLong("Population");
    
                    City client = new City(id, name, countryCode, district, population);
                    clients.add(client);
                }
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return clients;
    }
}
