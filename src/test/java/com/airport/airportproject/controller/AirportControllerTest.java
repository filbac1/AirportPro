package com.airport.airportproject.controller;

import com.airport.airportproject.facade.AirportFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirportController.class)
public class AirportControllerTest {

    @Autowired
    private AirportController airportController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportFacade airportFacade;

    @Test
    public void test() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                        .get("/airport/helloWorld")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World !"))
                .andReturn();
        result.getResponse().getContentAsString();
    }
}