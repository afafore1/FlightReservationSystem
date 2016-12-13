/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModel;

import flight.reservation.system.Admin;
import flight.reservation.system.Flight;
import flight.reservation.system.IUser;
import flight.reservation.system.User;
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
    
    public IUser LogUser(String username, String password) throws SQLException
    {
        IUser customer = null;
        PreparedStatement stmt = null;
        ResultSet rst = null;
        String user = null;
        String pass = null;
        String sql = "select id, username, password, firstname, lastname, address, zipcode, state, email, isAdmin from users where username = ? and password = ?";
        stmt = _conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rst = stmt.executeQuery();
        while(rst.next())
        {
            int id = rst.getInt("id");
            user = rst.getString("username");
            pass = rst.getString("password");
            String firstname = rst.getString("firstname");
            String lastname = rst.getString("lastname");
            String address = rst.getString("address");
            String zip = rst.getString("zipcode");
            String state = rst.getString("state");
            String email = rst.getString("email");
            boolean isAdmin = rst.getBoolean("isAdmin");
            if(user != null && pass != null)
            {
                if(isAdmin)
                {
                    customer = new Admin(id, firstname, lastname, address, zip, state, username, password, email);
                }else
                {
                    customer = new User(id, firstname, lastname, address, zip, state, username, password, email);
                }
            }
        }
        return customer;
    }
    
    public void InsertUserData(String firstname, String lastname, String address, String zip, String state, String username, String password,
            String email, String ssn, String securityQuestion, String answer, boolean isAdmin) throws SQLException
    {
        PreparedStatement stmt = null;
        String sql = "insert into users (firstname, lastname, address, zipcode, state, username, password, securityquestion, securityanswer, socialsecuritynumber, email, isAdmin) values (?,?,?,?,?,?,?,?,?,?,?,?)";
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
        stmt.setBoolean(12, isAdmin);
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
    
    public ArrayList<Flight> getAllFlights() throws SQLException
    {
        String name = null;
        String departureTime = null;
        String arrivalTime = null;
        Date departureDate = null;
        Date arrivalDate = null;
        String fromCity = null;
        String toCity = null;
        ArrayList<Flight> result = new ArrayList<>();
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
            departureDate = rs.getDate("departuredate");
            arrivalDate = rs.getDate("arrivaldate");
            fromCity = rs.getString("fromcity");
            toCity = rs.getString("tocity");
            Flight flight = new Flight(name, departureTime, arrivalTime, fromCity, toCity, departureDate, arrivalDate);
            result.add(flight);
        }
        return result;
    }
    
    public ArrayList<Flight> getUserFlight(int id) throws SQLException
    {
        ArrayList<Flight> result = new ArrayList<>();
        String name = null;
        String departureTime = null;
        String arrivalTime = null;
        Date departureDate = null;
        Date arrivalDate = null;
        String fromCity = null;
        String toCity = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select flights.name, flights.departuretime, flights.arrivaltime, flights.fromcity, flights.tocity, flights.departuredate, flights.arrivaldate from flights\n" +
                    "join userflight on flights.id = userflight.flightid\n" +
                    "join users on userflight.userid = users.id\n" +
                    "where users.id = ?";
        stmt = _conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        while(rs.next())
        {
            name = rs.getString("name");
            departureTime = rs.getString("departuretime");
            arrivalTime = rs.getString("arrivaltime");
            departureDate = rs.getDate("departuredate");
            arrivalDate = rs.getDate("arrivaldate");
            fromCity = rs.getString("fromcity");
            toCity = rs.getString("tocity");
            Flight flight = new Flight(name, departureTime, arrivalTime, fromCity, toCity, departureDate, arrivalDate);
            result.add(flight);
        }
        return result;
    }
}
