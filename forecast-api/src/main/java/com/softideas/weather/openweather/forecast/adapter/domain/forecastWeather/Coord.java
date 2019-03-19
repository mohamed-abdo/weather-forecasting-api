
package com.softideas.weather.openweather.forecast.adapter.domain.forecastWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Coord implements Serializable
{

    @JsonProperty("lat")

    private Double lat;
    @JsonProperty("lon")

    private Double lon;
    private final static long serialVersionUID = -1710641234624400329L;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

}
