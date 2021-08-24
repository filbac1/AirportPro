package com.airport.airportproject.facade;

import com.airport.airportproject.exception.NoFlightsException;
import com.amadeus.exceptions.ResponseException;

public interface AirportFacade {

    void get(String IATAfrom, String IATAto, String dateFrom,
             String dateTo, int passengerNum, String currency) throws ResponseException, NoFlightsException;
}
