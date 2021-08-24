package com.airport.airportproject.service;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.form.AirportTableForm;
import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;

import java.util.List;
import java.util.Map;

public interface AirportService {
    Map<AirportTableForm, List<AirportTableForm>> get();

    void save(Map<AirportTableForm, List<AirportTableForm>> map);
}
