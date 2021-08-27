package com.airport.airportproject.validator;

import org.springframework.stereotype.Component;

@Component
public class ValidatorImplementation implements Validator{

    @Override
    public boolean check(String iatAfrom, String iatAto, String dateFrom, String dateTo, int passengerNum, String currency) {
        if(iatAfrom.length() == 3 && iatAto.length() == 3 && currency.length() == 3) {
            if (passengerNum > 0) {
                return true;
            }
        }
        System.out.println("Check input ! ");
        return false;
    }
}
