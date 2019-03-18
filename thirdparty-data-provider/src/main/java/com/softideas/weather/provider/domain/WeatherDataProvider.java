package com.softideas.weather.provider.domain;


import com.softideas.weather.provider.domain.model.WeatherForecast;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface WeatherDataProvider {
    Optional<WeatherForecast> queryWeather(@NonNull String city, @Nullable String countryISOCode);
}
