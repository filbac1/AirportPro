package com.airport.airportproject.facade;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.form.AirportTableForm;
import com.amadeus.exceptions.ResponseException;

public interface AirportFacade {

    void get(String IATAfrom, String IATAto, String dateFrom,
             String dateTo, int passengerNum, String currency) throws ResponseException, NoFlightsException;

    AirportTableForm getForm(String iatAf, String iatAt, String dateF, String dateT, int passNum, String curren);
}
