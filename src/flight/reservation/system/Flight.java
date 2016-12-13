/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

import java.util.Date;

/**
 *
 * @author Ayomitunde
 */
public class Flight {
    private String name;
    private String departureTime;
    private String arrivalTime;
    private String fromCity;
    private String toCity;
    private Date departureDate;
    private Date arrivalDate;
    
    public Flight(String name, String dTime, String aTime, String fCity, String tCity, Date dDate, Date aDate)
    {
        this.name = name;
        departureTime = dTime;
        arrivalTime = aTime;
        fromCity = fCity;
        toCity = tCity;
        departureDate = dDate;
        arrivalDate = aDate;
    }
    
    // create getters below
    public String getName()
    {
        return this.name;
    }
    
    public String getDepartureTime()
    {
        return this.departureTime;
    }
    
    public String getArrivalTime()
    {
        return this.arrivalTime;
    }
    
    public String fromCity()
    {
        return fromCity;
    }
    
    public String toCity()
    {
        return toCity;
    }
    
    public Date departDate()
    {
        return departureDate;
    }
    
    public Date arrivalDate()
    {
        return arrivalDate;
    }
}
