/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

import java.util.ArrayList;

public class User implements IUser {
    protected String firstname;
    protected String lastname;
    protected String address;
    protected String zipcode;
    protected String state;
    protected String username;
    protected String password;
    protected String email;
    protected int id;
    protected ArrayList<Flight> userFlights;
    
    public User(int id, String firstname, String lastname, String address, String zip, String state, String username, String password, String email)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zipcode = zip;
        this.state = state;
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = id;
        userFlights = new ArrayList<>();
    }
    
    // instead of passing it all in ctor, create setters
    // things we want to expose 
    @Override
    public String getFirstName()
    {
        return this.firstname;
    }
    
    @Override
    public String getLastName()
    {
        return this.lastname;
    }
    
    @Override
    public String getUserName()
    {
        return this.username;
    }
    
    @Override
    public ArrayList<Flight> getUserFlights()
    {
        return this.userFlights;
    }
    
    @Override
    public void addToUserFlight(Flight flight)
    {
        userFlights.add(flight);
    }
    
    @Override
    public boolean canAddNewFlights()
    {
        return false;
    }
    
    @Override
    public boolean canUpdateFlights()
    {
        return false;
    }
    
    @Override
    public boolean canDeleteFlight()
    {
        return false;
    }
    
    public int getId()
    {
        return this.id;
    }
}
