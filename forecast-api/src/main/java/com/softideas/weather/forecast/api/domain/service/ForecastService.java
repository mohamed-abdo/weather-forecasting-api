package com.softideas.weather.forecast.api.domain.service;

import com.softideas.weather.forecast.api.domain.model.ForecastData;
import com.softideas.weather.forecast.api.domain.model.WeatherForecast;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface ForecastService {
    Optional<WeatherForecast> forecastWeather(@NonNull String city, @Nullable String country);
}
