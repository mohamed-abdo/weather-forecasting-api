package com.softideas.weather.openweather.forecast.adapter.domain.integration;

import com.softideas.weather.adaptee.domain.DataProvider;
import com.softideas.weather.adaptee.domain.model.WeatherForecast;
import com.softideas.weather.openweather.forecast.adapter.domain.model.WeatherApiResponse;
import com.softideas.weather.openweather.forecast.adapter.domain.repository.OpenWeatherApiRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataIntegrationTest.class)
@ComponentScan(basePackages = {"com.softideas.weather.*"})
public class DataIntegrationTest {

    private final String CITY = "Dubai";
    private final String COUNTRY = "UAE";
    private WeatherApiResponse weatherAPIResponse;

    @Autowired
    private DataProvider dataProvider;


    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(dataProvider);
        weatherAPIResponse = new WeatherApiResponse();
    }

    @After
    public void tearDown() throws Exception {
        dataProvider = null;
    }

    @Test
    public void testQueryWeather() {
        Optional<WeatherForecast> weatherForecast = dataProvider.queryWeather(CITY, COUNTRY);
        Assert.assertTrue(weatherForecast.isPresent());
    }
}