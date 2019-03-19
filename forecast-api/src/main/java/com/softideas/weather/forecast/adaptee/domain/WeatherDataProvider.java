package com.softideas.weather.forecast.adaptee.domain;


import com.softideas.weather.forecast.adaptee.domain.model.WeatherForecast;

import java.util.Optional;

public interface WeatherDataProvider {
    Optional<WeatherForecast> queryWeather(String city, String countryISOCode);
}
