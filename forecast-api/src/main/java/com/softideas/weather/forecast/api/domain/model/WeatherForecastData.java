package com.softideas.weather.forecast.api.domain.model;

import java.io.Serializable;

/**+
 * weather forecasting data, since it's average of forecast data,
 * so i take design decision to let data precision as double rather than decimal.
 */

public class WeatherForecastData implements Serializable {

    private static final long serialVersionUID = 6607519817073063356L;

    private Double morningAverageTemperature;

    private Double eveningAverageTemperature;

    private Double pressureAverageTemperature;

    public Double getMorningAverageTemperature() {
        return morningAverageTemperature;
    }

    public void setMorningAverageTemperature(Double morningAverageTemperature) {
        this.morningAverageTemperature = morningAverageTemperature;
    }

    public Double getEveningAverageTemperature() {
        return eveningAverageTemperature;
    }

    public void setEveningAverageTemperature(Double eveningAverageTemperature) {
        this.eveningAverageTemperature = eveningAverageTemperature;
    }

    public Double getPressureAverageTemperature() {
        return pressureAverageTemperature;
    }

    public void setPressureAverageTemperature(Double pressureAverageTemperature) {
        this.pressureAverageTemperature = pressureAverageTemperature;
    }
}
