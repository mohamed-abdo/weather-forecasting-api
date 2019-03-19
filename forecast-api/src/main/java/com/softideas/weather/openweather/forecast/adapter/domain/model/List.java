
package com.softideas.weather.openweather.forecast.adapter.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class List implements Serializable
{

    @JsonProperty("dt")

    private Long dt;
    @JsonProperty("main")

    private Main main;
    @JsonProperty("weather")

    private java.util.List<Weather> weather = null;
    @JsonProperty("clouds")

    private Clouds clouds;
    @JsonProperty("wind")

    private Wind wind;
    @JsonProperty("snow")

    private Snow snow;
    @JsonProperty("sys")

    private Sys sys;
    @JsonProperty("dt_txt")

    private String dtTxt;
    private final static long serialVersionUID = -2064531955305218430L;

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}
