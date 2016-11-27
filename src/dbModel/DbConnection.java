/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayomitunde
 */
public class DbConnection {
    protected Connection GetConnection() throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        try 
        {
            String driver = "oracle.jdbc.driver.OracleDriver";
            String host = "jdbc:mysql://localhost:3306/flightreservation";
            String username = "root";
            String password = "";
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(host, username, password);
        } catch(SQLException e)
        {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return conn;
    }
}
