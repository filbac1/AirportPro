package com.airport.airportproject.facade;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.form.AirportTableForm;
import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;

import java.util.List;
import java.util.Map;

public interface AirportFacade {

    void get(Amadeus amadeus, Map<AirportTableForm, List<AirportTableForm>> map, String iatAfrom, String iatAto, String dateFrom, String dateTo, int passengerNum, String currency, AirportTableForm searchForm) throws NoFlightsException, ResponseException;
}
