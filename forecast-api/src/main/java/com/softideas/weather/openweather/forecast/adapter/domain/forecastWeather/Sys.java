
package com.softideas.weather.openweather.forecast.adapter.domain.forecastWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Sys implements Serializable
{

    @JsonProperty("pod")

    private String pod;
    private final static long serialVersionUID = 1812231680469260108L;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

}
