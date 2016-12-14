/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

import java.util.ArrayList;

/**
 *
 * @author Ayomitunde
 */
public interface IUser {

    void addToUserFlight(Flight flight);

    // instead of passing it all in ctor, create setters
    // things we want to expose
    String getFirstName();

    String getLastName();

    ArrayList<Flight> getUserFlights();

    String getUserName();
    
    boolean canAddNewFlights();
    
    boolean canUpdateFlights();
    
    boolean canDeleteFlight();
    
    int getId();
    
    void setUserFlights(ArrayList<Flight> flight);
}
