package com.softideas.weather.forecast.api.domain.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {ForecastIntegrationTest.class})
@ComponentScan(basePackages = {
        "com.softideas.weather.forecast.api.domain.*",
        "com.softideas.weather.provider.domain.*",
        "com.softideas.weather.openweather.adapter.*"})
public class ForecastIntegrationTest {

    private final String CITY = "London";
    private final String COUNTRY = "UK";
    private final ZonedDateTime UTCTimeStartOfDay = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

    @Autowired
    private WeatherForecastController weatherForecastController;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getData() throws Exception {
        this.mockMvc.perform(get("/data/dubai/uae")).andDo(print()).andExpect(status().isOk());
    }
}