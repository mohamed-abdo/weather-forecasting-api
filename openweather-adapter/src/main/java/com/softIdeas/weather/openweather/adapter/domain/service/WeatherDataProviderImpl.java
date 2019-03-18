package com.softIdeas.weather.openweather.adapter.domain.service;

import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.WeatherAPIResponse;
import com.softIdeas.weather.openweather.adapter.domain.repository.OpenWeatherRepository;
import com.softideas.weather.provider.domain.WeatherDataProvider;
import com.softideas.weather.provider.domain.model.TemperatureUnit;
import com.softideas.weather.provider.domain.model.WeatherData;
import com.softideas.weather.provider.domain.model.WeatherForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeatherDataProviderImpl implements WeatherDataProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataProviderImpl.class);

    @Autowired
    private OpenWeatherRepository openWeatherRepository;

    public Optional<WeatherForecast> queryWeather(String city, String countryISOCode) {
        Objects.nonNull(city);
        WeatherAPIResponse weatherAPIResponse = openWeatherRepository.getData(city, countryISOCode);
        return Optional.ofNullable(weatherAPIResponse).map(this::Mapper);
    }

    private WeatherForecast Mapper(WeatherAPIResponse weatherAPIResponse) {

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
