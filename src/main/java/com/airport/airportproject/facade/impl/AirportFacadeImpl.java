package com.airport.airportproject.facade.impl;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.controller.AirportTableForm;
import com.airport.airportproject.facade.AirportFacade;
import com.airport.airportproject.service.AirportService;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class AirportFacadeImpl implements AirportFacade {

    private final Amadeus amadeus;
    private final AirportService airportService;
    private Map<AirportTableForm, List<AirportTableForm>> map = new HashMap<>();

    public AirportFacadeImpl(AirportService airportFacade) {
        this.airportService = airportFacade;
        this.amadeus = Amadeus
                .builder("xaHk1zkqebjwYpWnmpQvsOrMWeABjUcG", "Ta3qLdtXKkt23iSk")
                .build();
    }

    @Override
    public void get(String IATAfrom, String IATAto, String dateFrom, String dateTo, int passengerNum, String currency) throws ResponseException, NoFlightsException {
        AirportTableForm searchForm = new AirportTableForm(IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency);
        map = airportService.get(IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency);
        if (map.containsKey(searchForm)) {
            for (int i = 0; i < map.get(searchForm).size(); i++) {
                System.out.println(map.get(searchForm).get(i) + "Here we go again");
            }
        } else {
            List<AirportTableForm> list = new ArrayList<>();
            FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", IATAfrom)
                            .and("destinationLocationCode", IATAto)
                            .and("departureDate", dateFrom)
                            .and("returnDate", dateTo)
                            .and("adults", passengerNum)
                            .and("max", 1));

            if (flightOffersSearches.length != 0) {
                for (int i = 0; i < flightOffersSearches.length; i++) {  // broj ponuda
                    if (currency.equals(flightOffersSearches[i].getPrice().getCurrency())) {
                        AirportTableForm tableForm = new AirportTableForm(IATAfrom, IATAto, dateFrom, dateTo,
                                flightOffersSearches[i].getItineraries()[0].getSegments().length - 1,
                                flightOffersSearches[i].getItineraries()[1].getSegments().length - 1,
                                passengerNum, flightOffersSearches[i].getPrice().getCurrency(),
                                flightOffersSearches[i].getPrice().getGrandTotal());
                        System.out.println(tableForm);
                        list.add(tableForm);
                    }
                }
                map.put(searchForm, list);
                airportService.save(map);
            } else {
                throw new NoFlightsException("There are no flights on selected dates or " +
                        "there are no bookable seats for the selected number of passengers");
            }
        }
    }

    @Override
    public AirportTableForm getForm(String iatAf, String iatAt, String dateF, String dateT, int passNum, String curren) {
        return airportService.getTable(iatAf, iatAt, dateF, dateT, passNum, curren);
    }
}
