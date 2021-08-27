package com.airport.airportproject.service;

import com.airport.airportproject.form.AirportTableForm;

import java.util.List;
import java.util.Map;

public interface AirportService {
    Map<AirportTableForm, List<AirportTableForm>> get(String syd, String bkk, String s, String s1, int i, String eur);
    void save(Map<AirportTableForm, List<AirportTableForm>> map);
    AirportTableForm getTable(String iatAf, String iatAt, String dateF, String dateT, int passNum, String curren);
}
