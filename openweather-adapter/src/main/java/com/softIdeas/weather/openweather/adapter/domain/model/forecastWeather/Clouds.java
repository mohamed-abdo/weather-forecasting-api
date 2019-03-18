
package com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Clouds implements Serializable
{

    @JsonProperty("all")

    private Long all;
    private final static long serialVersionUID = -1926945603972181620L;

    public Long getAll() {
        return all;
    }

    public void setAll(Long all) {
        this.all = all;
    }

}
