
package com.softideas.weather.openweather.forecast.adapter.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class WeatherApiResponse implements Serializable
{

    @JsonProperty("cod")

    private String cod;
    @JsonProperty("message")

    private Double message;
    @JsonProperty("cnt")

    private Long cnt;
    @JsonProperty("list")

    private java.util.List<List> list = null;
    @JsonProperty("city")

    private City city;
    private final static long serialVersionUID = -8026497698366445557L;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
