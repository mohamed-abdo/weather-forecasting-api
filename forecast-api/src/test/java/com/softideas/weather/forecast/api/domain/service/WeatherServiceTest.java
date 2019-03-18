package com.softideas.weather.forecast.api.domain.service;

import com.softideas.weather.forecast.api.domain.model.WeatherForecastData;
import com.softideas.weather.provider.domain.WeatherDataProvider;
import com.softideas.weather.provider.domain.model.TemperatureUnit;
import com.softideas.weather.provider.domain.model.WeatherData;
import com.softideas.weather.provider.domain.model.WeatherForecast;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {WeatherServiceTest.class})
@ComponentScan(basePackages = {
        "com.softideas.weather.forecast.api.domain.*",
        "com.softideas.weather.provider.domain.*",
        "com.softideas.weather.openweather.adapter.*"})
public class WeatherServiceTest {
    private final String CITY = "London";
    private final String COUNTRY = "UK";
    private final ZonedDateTime UTCTimeStartOfDay = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

    private WeatherForecast weatherForecast;

    @Mock
    private WeatherDataProvider weatherDataProvider;

    @Autowired
    private WeatherService weatherService;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(weatherDataProvider);
        //TODO: fill object with more data
        weatherForecast = new WeatherForecast();
        weatherForecast.setCity(CITY);
        weatherForecast.setCountryISOCode(COUNTRY);
        weatherForecast.setTemperatureUnit(TemperatureUnit.Celsius);

        List weatherData = new ArrayList<WeatherData>();
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(3L).toInstant().toEpochMilli(), 20.3, 30.4, 44L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(6L).toInstant().toEpochMilli(), 25.3, 39.4, 42L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(9L).toInstant().toEpochMilli(), 12.4, 38.4, 41L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(12L).toInstant().toEpochMilli(), 13.5, 36.4, 44L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(15L).toInstant().toEpochMilli(), 26.6, 35.4, 46L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(18L).toInstant().toEpochMilli(), 23.3, 34.4, 48L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(21L).toInstant().toEpochMilli(), 21.3, 32.4, 40L, 22L));
        weatherData.add(
                new WeatherData(UTCTimeStartOfDay.plusHours(24L).toInstant().toEpochMilli(), 2.3, 10.4, 41L, 22L));

        weatherForecast.setWeatherData(weatherData);
    }

    @After
    public void tearDown() throws Exception {
        weatherDataProvider = null;
    }

    @Test
    public void testQueryWeatherResults() {
        when(weatherDataProvider.queryWeather(CITY, COUNTRY)).thenReturn(
                Optional.of(weatherForecast)
        );
        Optional<WeatherForecastData> weatherForecast = weatherService.foreCastWeather(CITY, COUNTRY);
        Assert.assertTrue(weatherForecast.isPresent());
    }
}
