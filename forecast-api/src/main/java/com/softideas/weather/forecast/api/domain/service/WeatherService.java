package com.softideas.weather.forecast.api.domain.service;

import com.softideas.weather.forecast.api.domain.model.WeatherForecastData;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherForecastData> foreCastWeather(@NonNull String city, @Nullable String country);
}
