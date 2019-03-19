package com.softideas.weather.forecast.api.domain.model;

public enum DayShift {
    DayTime(0),NightTime(1);
    int flag;
    DayShift(int flag){
        this.flag=flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
