
package com.softideas.weather.openweather.forecast.adapter.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Main implements Serializable
{

    @JsonProperty("temp")

    private Double temp;
    @JsonProperty("temp_min")

    private Double tempMin;
    @JsonProperty("temp_max")

    private Double tempMax;
    @JsonProperty("pressure")

    private Long pressure;
    @JsonProperty("sea_level")

    private Double seaLevel;
    @JsonProperty("grnd_level")

    private Long grndLevel;
    @JsonProperty("humidity")

    private Long humidity;
    @JsonProperty("temp_kf")

    private Long tempKf;
    private final static long serialVersionUID = -5767843902575084905L;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Long getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Long grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getTempKf() {
        return tempKf;
    }

    public void setTempKf(Long tempKf) {
        this.tempKf = tempKf;
    }

}
