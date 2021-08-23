package com.airport.airportproject.service;

import com.airport.airportproject.exception.NoFlightsException;
import com.amadeus.Airport;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightDate;

public interface AirportService {

    void get(String IATAfrom, String IATAto, String dateFrom,
             String dateTo, int passengerNum, String currency) throws ResponseException, NoFlightsException;
}
