package com.airport.airportproject.controller;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.service.AirportService;
import com.amadeus.exceptions.ResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportFacade) {
        this.airportService = airportFacade;
    }

    @GetMapping("/{IATAfrom}/{IATAto}/{dateFrom}/{dateTo}/{passengerNum}/{currency}")
    public void get(@PathVariable String IATAfrom,
                    @PathVariable String IATAto,
                    @PathVariable String dateFrom,
                    @PathVariable String dateTo,
                    @PathVariable int passengerNum,
                    @PathVariable String currency) throws ResponseException, NoFlightsException {

        airportService.get(IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency);
    }
}




