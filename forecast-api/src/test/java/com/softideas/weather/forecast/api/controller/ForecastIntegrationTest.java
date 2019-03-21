package com.softideas.weather.forecast.api.controller;

import com.softideas.common.aspects.validation.ValidatorException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.hamcrest.core.Is.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ForecastController.class)
@EnableAspectJAutoProxy
@ContextConfiguration(classes = ForecastController.class)
@ComponentScan(basePackages = {
        "com.softideas.weather.forecast.api.domain.*",
        "com.softideas.weather.forecast.adaptee.*",
        "com.softideas.weather.openweather.forecast.adapter.*",
        "com.softideas.common.*"})
public class ForecastIntegrationTest {

    private final String CITY = "Dubai";
    private final String COUNTRY = "UAE";
    private final ZonedDateTime UTCTimeStartOfDay = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidData() throws Exception {
        String url = String.format("/data/%s/%s", CITY, COUNTRY);
        this.mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testInvalidDataExpectNotFoundStatus() throws Exception {
        exceptionRule.expect(NestedServletException.class);
        exceptionRule.expectCause(isA(HttpClientErrorException.class));
        String url = String.format("/data/%s/%s", "INVALID_CITY", "INVALID_COUNTRY");
        this.mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    public void testRestrictedDataExpectBadRequestStatus() throws Exception {
        exceptionRule.expect(NestedServletException.class);
        exceptionRule.expectCause(isA(ValidatorException.class));
        String url = String.format("/data/%s/%s", "BAD_CITY", "INVALID_COUNTRY");
        this.mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
}