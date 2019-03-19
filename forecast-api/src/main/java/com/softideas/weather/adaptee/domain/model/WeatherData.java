package com.softideas.weather.adaptee.domain.model;

import java.io.Serializable;

public class WeatherData implements Serializable {

    private static final long serialVersionUID = -3404773571992947766L;


    private long timestamp;

    private Double minTemperature;
    private Double maxTemperature;

    private Long pressure;
    private Long humidity;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public WeatherData(long timestamp, Double minTemperature, Double maxTemperature, Long pressure, Long humidity) {
        this.timestamp = timestamp;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public static class Builder {
        private long timestamp;

        private Double minTemperature;
        private Double maxTemperature;

        private Long pressure;
        private Long humidity;

        public Builder setTimeStamp(Long timeStamp) {
            this.timestamp = timeStamp;
            return this;
        }

        public Builder setMinTemperature(Double minTemperature) {
            this.minTemperature = minTemperature;
            return this;
        }

        public Builder setMaxTemperature(Double maxTemperature) {
            this.maxTemperature = maxTemperature;
            return this;
        }


        public Builder setPressure(Long pressure) {
            this.pressure = pressure;
            return this;
        }


        public Builder setHumidity(Long humidity) {
            this.humidity = humidity;
            return this;
        }

        public WeatherData build() {
            return new WeatherData(timestamp, minTemperature, maxTemperature, pressure, humidity);
        }
    }
}
