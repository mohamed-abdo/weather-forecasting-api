
package com.softideas.weather.openweather.forecast.adapter.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class City implements Serializable
{

    @JsonProperty("id")

    private Long id;
    @JsonProperty("name")

    private String name;
    @JsonProperty("coord")

    private Coord coord;
    @JsonProperty("country")

    private String country;
    private final static long serialVersionUID = 5544933214451090483L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
