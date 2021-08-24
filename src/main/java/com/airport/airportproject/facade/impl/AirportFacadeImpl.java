package com.airport.airportproject.facade.impl;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.facade.AirportFacade;
import com.airport.airportproject.form.AirportTableForm;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AirportFacadeImpl implements AirportFacade {

    @Override
    public void get(Amadeus amadeus, Map<AirportTableForm, List<AirportTableForm>> map, String IATAfrom, String IATAto, String dateFrom, String dateTo, int passengerNum, String currency, AirportTableForm searchForm) throws NoFlightsException, ResponseException {
        List<AirportTableForm> list = new ArrayList<>();
        FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", IATAfrom)
                        .and("destinationLocationCode", IATAto)
                        .and("departureDate", dateFrom)
                        .and("returnDate", dateTo)
                        .and("adults", passengerNum)
                        .and("max", 200));
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
        } else {
            throw new NoFlightsException("There are no flights on selected dates or " +
                    "there are no bookable seats for the selected number of passengers");
        }
    }
}
