package com.softideas.weather.openweather.forecast.adapter.domain.integration;

import com.softideas.weather.forecast.adaptee.domain.WeatherDataProvider;
import com.softideas.weather.forecast.adaptee.domain.model.WeatherForecast;
import com.softideas.weather.openweather.forecast.adapter.domain.forecastWeather.WeatherAPIResponse;
import com.softideas.weather.openweather.forecast.adapter.domain.repository.OpenWeatherRepository;
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
@SpringBootTest
@ComponentScan(basePackages = {"com.softideas.weather.*"})
public class WeatherDataIntegrationTest {

    private final String CITY = "London";
    private final String COUNTRY = "UK";
    private WeatherAPIResponse weatherAPIResponse;

    @Autowired
    private WeatherDataProvider weatherDataProvider;

    @Autowired
    private OpenWeatherRepository openWeatherRepository;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(weatherDataProvider);
        weatherAPIResponse = new WeatherAPIResponse();
    }

    @After
    public void tearDown() throws Exception {
        weatherDataProvider = null;
    }

    @Test
    public void testQueryWeather() {
        Optional<WeatherForecast> weatherForecast = weatherDataProvider.queryWeather(CITY, COUNTRY);
        Assert.assertTrue(weatherForecast.isPresent());
    }
}