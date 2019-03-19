
package com.softideas.weather.openweather.forecast.adapter.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Snow implements Serializable
{

    @JsonProperty("3h")

    private Double _3h;
    private final static long serialVersionUID = 631351596604648798L;

    public Double get3h() {
        return _3h;
    }

    public void set3h(Double _3h) {
        this._3h = _3h;
    }

}
