package com.airport.airportproject.controller;

import com.airport.airportproject.form.AirportTableForm;
import com.airport.airportproject.repository.AirportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private AirportTableForm airportTableForm;
    private final AirportRepository airportRepository;

    public WebController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping("/create-project")
    public String createProjectForm(Model model) {
        model.addAttribute("airportTableForm", new AirportTableForm());
        return "create-project";
    }

    @PostMapping("/save-project")
    public String saveProjectSubmission(@ModelAttribute AirportTableForm airportTableForm) {
        airportTableForm = new AirportTableForm(airportTableForm.getAirportFrom(), airportTableForm.getAirportTo(),
                airportTableForm.getDepartureDate(), airportTableForm.getReturnDate(), airportTableForm.getNumberOfPassenger(),
                airportTableForm.getCurrency());
        return "result";
    }
}
