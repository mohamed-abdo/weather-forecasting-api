package com.softideas.weather.forecast.api.config;

import com.softideas.weather.forecast.api.domain.exception.ForecastNotAvailableException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<Object> handleNotFound(HttpClientErrorException ex) {
        return new ResponseEntity<>(
                ex.getStatusText(), new HttpHeaders(), ex.getStatusCode());
    }

    @ExceptionHandler({ForecastNotAvailableException.class})
    public ResponseEntity<Object> handleNoContent(Exception ex) {
        return new ResponseEntity<>(
                "no data available.", new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ Throwable.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                "internal error, please contact administrator.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
