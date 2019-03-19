package com.softideas.weather.forecast.api.controller;

import com.softideas.weather.forecast.api.domain.model.ForecastData;
import com.softideas.weather.forecast.api.domain.model.WeatherForecast;
import com.softideas.weather.forecast.api.domain.service.ForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ForecastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastController.class);

    @Autowired
    private ForecastService forecastService;

    @GetMapping("/data/{city}/{country}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    WeatherForecast getData(@PathVariable("city") @NonNull String city,
                            @PathVariable("country") @Nullable String countryISOCode) throws ResponseStatusException {
        LOGGER.info("receive request: {}, {}", city, countryISOCode);

        return forecastService.forecastWeather(city, countryISOCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("No model data available for city [%s] of country ISO code [%s] .", city, countryISOCode)));
    }
}
