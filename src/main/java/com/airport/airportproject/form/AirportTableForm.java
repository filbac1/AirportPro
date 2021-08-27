package com.airport.airportproject.form;

import com.amadeus.Airport;
import com.amadeus.resources.FlightDate;
import lombok.Data;

import java.util.Objects;

@Data
public class AirportTableForm {
    private String airportFrom;
    private String airportTo;
    private String departureDate;
    private String returnDate;
    private int departureTransfer;
    private int returnTransfer;
    private int numberOfPassenger;
    private String currency;
    private double fullPrice;

    public AirportTableForm(String airportFrom, String airportTo, String departureDate, String returnDate, int numberOfPassenger, String currency) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassenger = numberOfPassenger;
        this.currency = currency;
    }

    public AirportTableForm(String airportFrom, String airportTo, String departureDate, String returnDate, int departureTransfer, int returnTransfer, int numberOfPassenger, String currency, double fullPrice) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureTransfer = departureTransfer;
        this.returnTransfer = returnTransfer;
        this.numberOfPassenger = numberOfPassenger;
        this.currency = currency;
        this.fullPrice = fullPrice;
    }


    @Override
    public String toString() {
        return  "airportFrom = " + airportFrom + '\'' +
                " airportTo = " + airportTo + '\'' +
                " departureDate = " + departureDate + '\'' +
                " returnDate = " + returnDate + '\'' +
                " departureTransfer = " + departureTransfer +
                " returnTransfer = " + returnTransfer +
                " numberOfPassenger = " + numberOfPassenger +
                " currency = " + currency + '\'' +
                " fullPrice = " + fullPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportTableForm that = (AirportTableForm) o;
        return numberOfPassenger == that.numberOfPassenger && Objects.equals(airportFrom, that.airportFrom) && Objects.equals(airportTo, that.airportTo) && Objects.equals(departureDate, that.departureDate) && Objects.equals(returnDate, that.returnDate) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportFrom, airportTo, departureDate, returnDate, numberOfPassenger, currency);
    }
}
