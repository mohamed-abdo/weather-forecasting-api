package com.softIdeas.weather.openweather.adapter.domain.service;

import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.City;
import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.List;
import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.Main;
import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.WeatherAPIResponse;
import com.softIdeas.weather.openweather.adapter.domain.repository.OpenWeatherRepository;
import com.softideas.weather.provider.domain.WeatherDataProvider;
import com.softideas.weather.provider.domain.model.WeatherForecast;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.softideas.weather.*"})
public class WeatherDataProviderImplTest {

    private final String CITY = "London";
    private final String COUNTRY = "UK";
    private WeatherAPIResponse weatherAPIResponse;

    @Autowired
    private WeatherDataProvider weatherDataProvider;

    @MockBean
    private OpenWeatherRepository openWeatherRepository;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(weatherDataProvider);
        //TODO: fill object with more data
        weatherAPIResponse = new WeatherAPIResponse();
        City city=new City();
        city.setName("Dubai");
        city.setCountry("UAE");
        weatherAPIResponse.setCity(city);
        Main main=new Main();
        main.setHumidity(70L);
        main.setPressure(87L);
        main.setTemp(40.0);
        main.setTempMin(22.6);
        main.setTempMax(44.8);
        List data= new List();
        data.setDt(LocalDateTime.now().atZone(ZoneOffset.UTC).toInstant().toEpochMilli());
        data.setMain(main);
        weatherAPIResponse.setList(Collections.singletonList(data));
    }

    @After
    public void tearDown() throws Exception {
        weatherDataProvider = null;
    }

    @Test
    public void testQueryWeatherNoResults() {
        when(openWeatherRepository.getData(CITY, COUNTRY)).thenReturn(
                weatherAPIResponse
        );
        Optional<WeatherForecast> weatherForecast = weatherDataProvider.queryWeather(CITY, COUNTRY);
        Assert.assertTrue(weatherForecast.isPresent());
    }

}