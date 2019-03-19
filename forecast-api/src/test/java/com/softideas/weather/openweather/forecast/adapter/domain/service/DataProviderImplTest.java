package com.softideas.weather.openweather.forecast.adapter.domain.service;

import com.softideas.weather.adaptee.domain.DataProvider;
import com.softideas.weather.adaptee.domain.model.WeatherForecast;
import com.softideas.weather.openweather.forecast.adapter.domain.model.City;
import com.softideas.weather.openweather.forecast.adapter.domain.model.List;
import com.softideas.weather.openweather.forecast.adapter.domain.model.Main;
import com.softideas.weather.openweather.forecast.adapter.domain.model.WeatherApiResponse;
import com.softideas.weather.openweather.forecast.adapter.domain.repository.OpenWeatherApiRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
@SpringBootTest(classes = DataProviderImplTest.class)
@ComponentScan(basePackages = {"com.softideas.weather.*"})
public class DataProviderImplTest {

    private final String CITY = "Dubai";
    private final String COUNTRY = "UAE";
    private WeatherApiResponse weatherAPIResponse;

    private DataProvider dataProvider;

    @Mock
    private OpenWeatherApiRepository openWeatherAPIRepository;

    @Before
    public void setUp() throws Exception {
        dataProvider = new DataProviderImpl(openWeatherAPIRepository);
        Assert.assertNotNull(dataProvider);
        //TODO: fill object with more data
        weatherAPIResponse = new WeatherApiResponse();
        City city = new City();
        city.setName("Dubai");
        city.setCountry("UAE");
        weatherAPIResponse.setCity(city);
        Main main = new Main();
        main.setHumidity(70L);
        main.setPressure(87L);
        main.setTemp(40.0);
        main.setTempMin(22.6);
        main.setTempMax(44.8);
        List data = new List();
        data.setDt(LocalDateTime.now().atZone(ZoneOffset.UTC).toInstant().toEpochMilli());
        data.setMain(main);
        weatherAPIResponse.setList(Collections.singletonList(data));
    }

    @After
    public void tearDown() throws Exception {
        dataProvider = null;
    }

    @Test
    public void testQueryWeather() {
        when(openWeatherAPIRepository.getData(CITY, COUNTRY)).thenReturn(
                Optional.of(weatherAPIResponse)
        );
        Optional<WeatherForecast> weatherForecast = dataProvider.queryWeather(CITY, COUNTRY);
        Assert.assertTrue(weatherForecast.isPresent());
    }

}