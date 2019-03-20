package com.softideas.weather.forecast.api.controller;

import com.softideas.weather.forecast.api.domain.exception.ForecastNotAvailableException;
import com.softideas.weather.forecast.api.domain.model.WeatherForecast;
import com.softideas.weather.forecast.api.domain.service.ForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
public class ForecastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastController.class);

    @Autowired
    private ForecastService forecastService;


    @GetMapping({"/data/{city}", "/data/{city}/{countryISOCode}"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    WeatherForecast getData(@PathVariable("city") @NonNull String city,
                            @PathVariable(value = "countryISOCode", required = false) @Nullable String countryISOCode) throws ForecastNotAvailableException {
        LOGGER.info("receive request: {}, {}", city, countryISOCode);

        return forecastService.forecastWeather(city, countryISOCode)
                .orElseThrow(() -> new ForecastNotAvailableException(HttpStatus.NO_CONTENT, String.format("No model data available for city [%s] of country ISO code [%s] .", city, countryISOCode)));
    }

    @GetMapping({"/", "/welcome"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity welcome() {
        final String welcomePageUrl = "/swagger-ui.html";
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(welcomePageUrl));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

}
