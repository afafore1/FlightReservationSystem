/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayomitunde
 */
public class DbInteraction {
    private Connection _conn;
    public DbInteraction()
    {
        try {
            DbConnection connection = new DbConnection();
            _conn = connection.GetConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DbInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean UserExist(String username) throws SQLException
    {
        PreparedStatement stmt = null;
        ResultSet rst = null;
        String sql = "select username from users where username= ?";
        stmt = _conn.prepareStatement(sql);
        stmt.setString(1, username);
        rst = stmt.executeQuery();
        while(rst.next())
        {
            return true;
        }
        return false;
    }
    
    public boolean LogUser(String username, String password) throws SQLException
    {
        PreparedStatement stmt = null;
        ResultSet rst = null;
        String user = null;
        String pass = null;
        String sql = "select username, password from users where username = ? and password = ?";
        stmt = _conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rst = stmt.executeQuery();
        while(rst.next())
        {
            user = rst.getString("username");
            pass = rst.getString("password");
            if(user != null && pass != null) return true;
        }
        return false;
    }
    
    public void InsertUserData(String firstname, String lastname, String address, String zip, String state, String username, String password,
            String email, String ssn, String securityQuestion, String answer) throws SQLException
    {
        PreparedStatement stmt = null;
        String sql = "insert into users (firstname, lastname, address, zipcode, state, username, password, securityquestion, securityanswer, socialsecuritynumber, email) values (?,?,?,?,?,?,?,?,?,?,?)";
        stmt = _conn.prepareStatement(sql);
        stmt.setString(1, firstname);
        stmt.setString(2, lastname);
        stmt.setString(3, address);
        stmt.setString(4, zip);
        stmt.setString(5, state);
        stmt.setString(6, username);
        stmt.setString(7, password);
        stmt.setString(8, securityQuestion);
        stmt.setString(9, answer);
        stmt.setString(10, ssn); 
        stmt.setString(11, email); 
        stmt.executeUpdate();       
    }
    
    public void AddFlightInfo(String name, String departureTime, String arrivalTime, Date departureDate, Date arrivalDate, String fromCity, String toCity) throws SQLException
    {
        PreparedStatement stmt = null;
        String sql = "insert into flights (name, departuretime, arrivaltime, fromcity, tocity, departuredate, arrivaldate) values (?,?,?,?,?,?,?)";
        stmt = _conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, departureTime);
        stmt.setString(3, arrivalTime);
        stmt.setDate(6, departureDate);
        stmt.setDate(7, arrivalDate);
        stmt.setString(4, fromCity);
        stmt.setString(5, toCity);
        stmt.executeUpdate();
    }
    
    public HashMap<Integer, ArrayList<String>> GetAllFlights() throws SQLException
    {
        int count = 0;
        String name = null;
        String departureTime = null;
        String arrivalTime = null;
        String departureDate = null;
        String arrivalDate = null;
        String fromCity = null;
        String toCity = null;
        HashMap<Integer, ArrayList<String>> result = new HashMap<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from flights";
        stmt = _conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next())
        {
            name = rs.getString("name");
            departureTime = rs.getString("departuretime");
            arrivalTime = rs.getString("arrivaltime");
            departureDate = rs.getDate("departuredate").toString();
            arrivalDate = rs.getDate("arrivaldate").toString();
            fromCity = rs.getString("fromcity");
            toCity = rs.getString("tocity");
            ArrayList<String> rst = new ArrayList<>();
            rst.add(name); rst.add(departureTime); rst.add(arrivalTime); rst.add(departureDate); rst.add(arrivalDate); rst.add(fromCity); rst.add(toCity); 
            count++;
            result.put(count, rst);
        }
        return result;
    }
}
