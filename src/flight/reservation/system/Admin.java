/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

/**
 *
 * @author Ayomitunde
 */
public class Admin extends User implements IUser{
    public Admin(int id, String firstname, String lastname, String address, String zip, String state, String username, String password, String email)
    {
        super(id, firstname, lastname, address, zip, state, username, password, email);
    }
    
     @Override
    public boolean canAddNewFlights()
    {
        return true;
    }
    
    @Override
    public boolean canUpdateFlights()
    {
        return true;
    }
    
    @Override
    public boolean canDeleteFlight()
    {
        return true;
    }
    
}
