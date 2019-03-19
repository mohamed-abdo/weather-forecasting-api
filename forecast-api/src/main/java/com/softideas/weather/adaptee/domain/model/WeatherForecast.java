package com.softideas.weather.adaptee.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeatherForecast implements Serializable {

    private static final long serialVersionUID = -2106618805073052909L;

    private TemperatureUnit temperatureUnit;
    private String city;
    private String countryISOCode;

    private List<WeatherData> weatherData;

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(TemperatureUnit temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public List<WeatherData> getWeatherData() {
        return Optional.ofNullable(weatherData).orElse(new ArrayList<>());
    }

    public void setWeatherData(List<WeatherData> weatherData) {
        this.weatherData = weatherData;
    }
}
