package com.airport.airportproject;

import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmadeusExample {

    public static void main(String[] args) throws ResponseException {
        SpringApplication.run(AmadeusExample.class, args);

        Amadeus amadeus = Amadeus
                .builder("xaHk1zkqebjwYpWnmpQvsOrMWeABjUcG", "Ta3qLdtXKkt23iSk")
                .build();


    }
}

