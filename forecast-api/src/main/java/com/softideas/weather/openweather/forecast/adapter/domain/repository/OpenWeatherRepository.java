package com.softideas.weather.openweather.forecast.adapter.domain.repository;

import com.softideas.weather.openweather.forecast.adapter.domain.forecastWeather.WeatherAPIResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface OpenWeatherRepository {
    WeatherAPIResponse getData(@NonNull String city, @Nullable String countryISOCode);
}
