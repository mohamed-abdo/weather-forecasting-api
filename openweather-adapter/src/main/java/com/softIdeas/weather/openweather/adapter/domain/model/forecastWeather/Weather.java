
package com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Weather implements Serializable
{

    @JsonProperty("id")

    private Long id;
    @JsonProperty("main")

    private String main;
    @JsonProperty("description")

    private String description;
    @JsonProperty("icon")

    private String icon;
    private final static long serialVersionUID = -2133859750668035421L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
