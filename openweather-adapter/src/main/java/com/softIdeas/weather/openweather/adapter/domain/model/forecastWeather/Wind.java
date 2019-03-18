
package com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Wind implements Serializable
{

    @JsonProperty("speed")

    private Double speed;
    @JsonProperty("deg")

    private Double deg;
    private final static long serialVersionUID = -3729404707747830931L;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

}
