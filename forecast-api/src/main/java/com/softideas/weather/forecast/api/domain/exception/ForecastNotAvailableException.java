package com.softideas.weather.forecast.api.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ForecastNotAvailableException extends HttpStatusCodeException {
    public ForecastNotAvailableException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
