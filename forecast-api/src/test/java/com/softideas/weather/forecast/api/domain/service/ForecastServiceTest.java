package com.softideas.weather.forecast.api.domain.service;

import com.softideas.common.aspects.validation.ValidatorException;
import com.softideas.weather.adaptee.domain.DataProvider;
import com.softideas.weather.adaptee.domain.model.TemperatureUnit;
import com.softideas.weather.adaptee.domain.model.WeatherData;
import com.softideas.weather.adaptee.domain.model.WeatherForecast;
import com.softideas.weather.forecast.api.domain.model.ForecastData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {ForecastServiceTest.class})
@ComponentScan(basePackages = {
        "com.softideas.weather.forecast.api.domain.*",
        "com.softideas.weather.forecast.adaptee.*",
        "com.softideas.weather.openweather.forecast.adapter.*",
        "com.softideas.common.*"})
public class ForecastServiceTest {
    private final String CITY = "Dubai";
    private final String COUNTRY = "UAE";
    private final ZonedDateTime UTCTimeStartOfDay = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

    private WeatherForecast weatherForecast;

    @Mock
    private DataProvider dataProvider;

    @Autowired
    private ForecastService forecastService;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(dataProvider);
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
        dataProvider = null;
    }

    @Test
    public void testQueryWeatherResults() throws ValidatorException {
        when(dataProvider.queryWeather(CITY, COUNTRY)).thenReturn(
                Optional.of(weatherForecast)
        );
        Optional<com.softideas.weather.forecast.api.domain.model.WeatherForecast> weatherForecast = forecastService.forecastWeather(CITY, COUNTRY);
        Assert.assertTrue(weatherForecast.isPresent());
    }
}
