package com.softideas.weather.adaptee.domain.model;


public enum TemperatureUnit {
    Celsius(1),
    Fahrenheit(2);

    int unit;

    TemperatureUnit(int unit) {
        this.unit = unit;
    }

    int getUnit(){
        return this.unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
