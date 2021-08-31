package com.airport.airportproject.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class AirportTableForm {
    @Min(3)
    @Max(3)
    private String airportFrom;

    @Min(3)
    @Max(3)
    private String airportTo;
    private String departureDate;
    private String returnDate;
    private int departureTransfer;
    private int returnTransfer;
    private int numberOfPassenger;
    private String currency;
    private double fullPrice;

    public AirportTableForm() {

    }

    public AirportTableForm(String airportFrom, String airportTo, String departureDate, String returnDate, int numberOfPassenger, String currency) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassenger = numberOfPassenger;
        this.currency = currency;
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

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getDepartureTransfer() {
        return departureTransfer;
    }

    public void setDepartureTransfer(int departureTransfer) {
        this.departureTransfer = departureTransfer;
    }

    public int getReturnTransfer() {
        return returnTransfer;
    }

    public void setReturnTransfer(int returnTransfer) {
        this.returnTransfer = returnTransfer;
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassenger = numberOfPassenger;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }
}
