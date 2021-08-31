package com.airport.airportproject.controller;

import com.airport.airportproject.exception.NoFlightsException;
import com.airport.airportproject.facade.AirportFacade;
import com.airport.airportproject.form.AirportTableForm;
import com.amadeus.exceptions.ResponseException;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
public class AirportController  {
    private final AirportFacade airportFacade;
    public AirportController(AirportFacade airportFacade) {
        this.airportFacade = airportFacade;
    }

    @GetMapping("airport/{IATAfrom}/{IATAto}/{dateFrom}/{dateTo}/{passengerNum}/{currency}")
    public void get(@PathVariable String IATAfrom,
                    @PathVariable String IATAto,
                    @PathVariable String dateFrom,
                    @PathVariable String dateTo,
                    @PathVariable int passengerNum,
                    @PathVariable String currency) throws ResponseException, NoFlightsException {
            airportFacade.get(IATAfrom, IATAto, dateFrom, dateTo, passengerNum, currency);
    }
    @GetMapping("airport/{IATAf}/{IATAt}/{dateF}/{dateT}/{passNum}/{curren}/getAirportForm")
    public AirportTableForm getTable(@PathVariable String IATAf,
                                     @PathVariable String IATAt,
                                     @PathVariable String dateF,
                                     @PathVariable String dateT,
                                     @PathVariable int passNum,
                                     @PathVariable String curren) throws ResponseException, NoFlightsException {

        return airportFacade.getForm(IATAf, IATAt, dateF, dateT, passNum, curren);
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World !";
    }
}





