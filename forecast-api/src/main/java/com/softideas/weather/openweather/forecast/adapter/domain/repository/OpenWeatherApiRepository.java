package com.softideas.weather.openweather.forecast.adapter.domain.repository;

import com.softideas.weather.openweather.forecast.adapter.domain.model.WeatherApiResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface OpenWeatherApiRepository {
    Optional<WeatherApiResponse> getData(@NonNull String city, @Nullable String countryISOCode);
}
