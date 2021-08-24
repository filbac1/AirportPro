package com.airport.airportproject.controller;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.facade.AirportFacade;
import com.amadeus.exceptions.ResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportFacade airportFacade;

    public AirportController(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
    }

    @GetMapping("/{IATAfrom}/{IATAto}/{dateFrom}/{dateTo}/{passengerNum}/{currency}")
    public void get(@PathVariable String IATAfrom,
                    @PathVariable String IATAto,
                    @PathVariable String dateFrom,
                    @PathVariable String dateTo,
                    @PathVariable int passengerNum,
                    @PathVariable String currency) throws ResponseException, NoFlightsException {

        airportFacade.get(IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency);
    }
}




