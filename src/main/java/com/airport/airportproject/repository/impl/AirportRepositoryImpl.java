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
    private List<AirportTableForm> list;

    public List<AirportTableForm> getList() {
        return list;
    }


    @Override
    public Map<AirportTableForm, List<AirportTableForm>> get() {
        return mapRepo;
    }

    @Override
    public void save(Map<AirportTableForm, List<AirportTableForm>> map) {
        mapRepo = map;
    }

    @Override
    public AirportTableForm getTable(String iatAf, String iatAt, String dateF, String dateT, int passNum, String curren) {
        AirportTableForm helpForm = new AirportTableForm(iatAf, iatAt, dateF, dateT, passNum, curren);
        if (!(mapRepo.isEmpty())) {
        List<AirportTableForm> helpList = mapRepo.get(helpForm);
            for (int i = 0; i < helpList.size(); i++) {
                if (helpForm.equals(helpList.get(i))) {
                    return helpList.get(i);
                }
            }
        }
        return null;
    }
}
