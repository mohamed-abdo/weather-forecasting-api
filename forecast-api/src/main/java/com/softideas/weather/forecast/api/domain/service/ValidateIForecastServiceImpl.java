package com.softideas.weather.forecast.api.domain.service;

import java.util.Objects;
import java.util.function.Predicate;

public class ValidateIForecastServiceImpl implements Predicate<String> {
    @Override
    public boolean test(String param) {
        if (Objects.isNull(param))
            return false;
        if (param.contentEquals("BAD_CITY"))
            return false;
        return true;
    }
}
