package com.airport.airportproject.service.impl;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.facade.AirportFacade;
import com.airport.airportproject.form.AirportTableForm;
import com.airport.airportproject.service.AirportService;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
public class AirportServiceImpl implements AirportService {

    private final Amadeus amadeus;
    private final AirportFacade airportFacade;
    private Map<AirportTableForm, List<AirportTableForm>> map = new HashMap<>();

    public AirportServiceImpl(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
        this.amadeus = Amadeus
                .builder("xaHk1zkqebjwYpWnmpQvsOrMWeABjUcG", "Ta3qLdtXKkt23iSk")
                .build();
    }

    @Override
    public void get(String IATAfrom, String IATAto, String dateFrom, String dateTo, int passengerNum, String currency) throws ResponseException, NoFlightsException {
        AirportTableForm searchForm = new AirportTableForm(IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency);
        if (map.containsKey(searchForm)) {
            for (int i = 0; i < map.get(searchForm).size(); i++) {
                System.out.println(map.get(searchForm).get(i) + "Here we go again");
            }
        } else {
            airportFacade.get(amadeus, map, IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency, searchForm);
        }
    }
}
