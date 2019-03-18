package com.softideas.weather.forecast.api.domain.controller;

import com.softideas.weather.forecast.api.domain.model.WeatherForecastData;
import com.softideas.weather.forecast.api.domain.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherForecastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForecastController.class);

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/data/{city}/{country}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    WeatherForecastData getData(@PathVariable("city") @NonNull String city,
                                @PathVariable("country") @Nullable String countryISOCode) {
        LOGGER.info("receive request: {}, {}", city, countryISOCode);

        return weatherService.foreCastWeather(city, countryISOCode).orElse(new WeatherForecastData());
    }
}
