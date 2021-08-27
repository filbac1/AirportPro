package com.airport.airportproject.validator;

public interface Validator {
    boolean check(String iatAfrom, String iatAto, String dateFrom, String dateTo, int passengerNum, String currency);
}
