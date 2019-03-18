package com.softideas.weather.forecast.api.domain.service;

import com.softideas.weather.forecast.api.domain.controller.WeatherForecastController;
import com.softideas.weather.forecast.api.domain.model.WeatherForecastData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Override
    public Optional<WeatherForecastData> foreCastWeather(String city, String country) {
        LOGGER.info("receive service request: {}, {}", city, country);
        return Optional.empty();
    }
}
