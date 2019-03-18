package com.softIdeas.weather.openweather.adapter.domain.repository;

import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.WeatherAPIResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface OpenWeatherRepository {
    WeatherAPIResponse getData(@NonNull String city, @Nullable String countryISOCode);
}
