package com.airport.airportproject.service.impl;

import com.airport.airportproject.repository.AirportRepository;
import com.airport.airportproject.service.AirportService;
import com.airport.airportproject.form.AirportTableForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Map<AirportTableForm, List<AirportTableForm>> get() {
        return airportRepository.get();
    }

    @Override
    public void save(Map<AirportTableForm, List<AirportTableForm>> map) {
        airportRepository.save(map);
    }


}
