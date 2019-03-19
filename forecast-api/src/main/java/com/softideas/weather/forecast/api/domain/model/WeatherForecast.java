package com.softideas.weather.forecast.api.domain.model;

import java.io.Serializable;

public class WeatherForecast implements Serializable {
    private Double morningAverageTemperature;
    private Double nightAverageTemperature;
    private Double pressureAverage;

    public Double getMorningAverageTemperature() {
        return morningAverageTemperature;
    }

    public void setMorningAverageTemperature(Double morningAverageTemperature) {
        this.morningAverageTemperature = morningAverageTemperature;
    }

    public Double getNightAverageTemperature() {
        return nightAverageTemperature;
    }

    public void setNightAverageTemperature(Double nightAverageTemperature) {
        this.nightAverageTemperature = nightAverageTemperature;
    }

    public Double getPressureAverage() {
        return pressureAverage;
    }

    public void setPressureAverage(Double pressureAverage) {
        this.pressureAverage = pressureAverage;
    }

    public WeatherForecast() {
    }

    public WeatherForecast(Double morningAverageTemperature, Double nightAverageTemperature, Double pressureAverage) {
        this.morningAverageTemperature = morningAverageTemperature;
        this.nightAverageTemperature = nightAverageTemperature;
        this.pressureAverage = pressureAverage;
    }
}
