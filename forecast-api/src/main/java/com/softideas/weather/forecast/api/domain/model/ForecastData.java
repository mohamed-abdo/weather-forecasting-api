package com.softideas.weather.forecast.api.domain.model;

import java.io.Serializable;

/**
 * +
 * weather forecasting data, since it's average of model data,
 * so i take design decision to let data precision as double rather than decimal.
 */

public class ForecastData implements Serializable {

    private static final long serialVersionUID = 6607519817073063356L;

    private DayShift dayShift;

    private Double averageTemperature;

    private Double pressureAverageTemperature;

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public DayShift getDayShift() {
        return dayShift;
    }

    public void setDayShift(DayShift dayShift) {
        this.dayShift = dayShift;
    }

    public Double getPressureAverageTemperature() {
        return pressureAverageTemperature;
    }

    public void setPressureAverageTemperature(Double pressureAverageTemperature) {
        this.pressureAverageTemperature = pressureAverageTemperature;
    }

    public ForecastData() {
    }

    public ForecastData(DayShift dayShift, Double averageTemperature, Double pressureAverageTemperature) {
        this.dayShift = dayShift;
        this.averageTemperature = averageTemperature;
        this.pressureAverageTemperature = pressureAverageTemperature;
    }

    public static class Builder {

        private DayShift dayShift;

        private Double averageTemperature;

        private Double pressureAverageTemperature;

        public Builder setMorningAverageTemperature(DayShift dayShift) {
            this.dayShift = dayShift;
            return this;
        }

        public Builder setAverageTemperature(Double averageTemperature) {
            this.averageTemperature = averageTemperature;
            return this;
        }

        public Builder setPressureAverageTemperature(Double pressureAverageTemperature) {
            this.pressureAverageTemperature = pressureAverageTemperature;
            return this;
        }

        public ForecastData build() {
            return new ForecastData(this.dayShift, this.averageTemperature, this.pressureAverageTemperature);
        }
    }
}
