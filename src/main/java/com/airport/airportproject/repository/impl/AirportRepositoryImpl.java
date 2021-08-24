package com.airport.airportproject.repository.impl;

import com.airport.airportproject.form.AirportTableForm;
import com.airport.airportproject.repository.AirportRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AirportRepositoryImpl implements AirportRepository {

    private Map<AirportTableForm, List<AirportTableForm>> mapRepo = new HashMap<>();

    @Override
    public Map<AirportTableForm, List<AirportTableForm>> get() {
        return mapRepo;
    }

    @Override
    public void save(Map<AirportTableForm, List<AirportTableForm>> map) {
        mapRepo = map;
    }
}
