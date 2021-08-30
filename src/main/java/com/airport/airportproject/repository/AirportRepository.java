package com.airport.airportproject.repository;

import com.airport.airportproject.controller.AirportTableForm;

import java.util.List;
import java.util.Map;

public interface AirportRepository {

    Map<AirportTableForm, List<AirportTableForm>> get();
    void save(Map<AirportTableForm, List<AirportTableForm>> map);
    AirportTableForm getTable(String iatAf, String iatAt, String dateF, String dateT, int passNum, String curren);
}

