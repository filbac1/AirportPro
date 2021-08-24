package com.airport.airportproject.repository;

import com.airport.airportproject.form.AirportTableForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface AirportRepository {
    Map<AirportTableForm, List<AirportTableForm>> get();
    void save(Map<AirportTableForm, List<AirportTableForm>> map);
}

