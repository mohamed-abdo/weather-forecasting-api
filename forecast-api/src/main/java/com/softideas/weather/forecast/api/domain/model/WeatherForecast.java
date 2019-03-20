package com.softideas.weather.forecast.api.domain.model;

import java.io.Serializable;

public class WeatherForecast implements Serializable {
    private String morningTemperature;
    private String nightTemperature;
    private String pressure;

    public String getMorningTemperature() {
        return morningTemperature;
    }

    public void setMorningTemperature(String morningTemperature) {
        this.morningTemperature = morningTemperature;
    }

    public String getNightTemperature() {
        return nightTemperature;
    }

    public void setNightTemperature(String nightTemperature) {
        this.nightTemperature = nightTemperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public WeatherForecast() {
    }

    public WeatherForecast(String morningTemperature, String nightTemperature, String pressureAverage) {
        this.morningTemperature = morningTemperature;
        this.nightTemperature = nightTemperature;
        this.pressure = pressureAverage;
    }
}
