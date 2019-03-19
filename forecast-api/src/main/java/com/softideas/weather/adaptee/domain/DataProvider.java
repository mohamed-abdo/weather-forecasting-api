package com.softideas.weather.adaptee.domain;


import com.softideas.weather.adaptee.domain.model.WeatherForecast;

import java.util.Optional;

public interface DataProvider {
    Optional<WeatherForecast> queryWeather(String city, String countryISOCode);
}
