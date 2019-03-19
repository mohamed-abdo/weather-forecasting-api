package com.softideas.weather.openweather.forecast.adapter.domain.service;

import com.softideas.weather.adaptee.domain.DataProvider;
import com.softideas.weather.adaptee.domain.model.TemperatureUnit;
import com.softideas.weather.adaptee.domain.model.WeatherData;
import com.softideas.weather.adaptee.domain.model.WeatherForecast;
import com.softideas.weather.openweather.forecast.adapter.domain.model.WeatherApiResponse;
import com.softideas.weather.openweather.forecast.adapter.domain.repository.OpenWeatherApiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataProviderImpl implements DataProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataProviderImpl.class);


    private OpenWeatherApiRepository openWeatherAPIRepository;

    @Autowired
    public DataProviderImpl(OpenWeatherApiRepository openWeatherAPIRepository) {
        this.openWeatherAPIRepository = openWeatherAPIRepository;
    }

    public Optional<WeatherForecast> queryWeather(String city, String countryISOCode) {
        Objects.nonNull(city);
        LOGGER.info("Fetching data city:{} country code: {}", city, countryISOCode);
        Optional<WeatherApiResponse> weatherAPIResponse = openWeatherAPIRepository.getData(city, countryISOCode);
        return weatherAPIResponse.map(this::Mapper);
    }

    private WeatherForecast Mapper(WeatherApiResponse weatherAPIResponse) {

        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setTemperatureUnit(TemperatureUnit.Celsius);
        weatherForecast.setCity(weatherAPIResponse.getCity().getName());
        weatherForecast.setCountryISOCode(weatherAPIResponse.getCity().getCountry());
        weatherForecast.setWeatherData(weatherAPIResponse.getList().stream().map(w ->
                new WeatherData.Builder()
                        .setTimeStamp(w.getDt())
                        .setMinTemperature(w.getMain().getTempMin())
                        .setMaxTemperature(w.getMain().getTempMax())
                        .setPressure(w.getMain().getPressure())
                        .setHumidity(w.getMain().getHumidity())
                        .build()
        ).collect(Collectors.toList()));
        return weatherForecast;
    }
}
