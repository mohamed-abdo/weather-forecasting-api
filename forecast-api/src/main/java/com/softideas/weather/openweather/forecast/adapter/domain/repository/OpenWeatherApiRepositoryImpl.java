package com.softideas.weather.openweather.forecast.adapter.domain.repository;

import com.softideas.weather.openweather.forecast.adapter.domain.model.WeatherApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class OpenWeatherApiRepositoryImpl implements OpenWeatherApiRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherApiRepositoryImpl.class);
    @Value("${api-endpoint}")
    private String apiEndPoint;

    @Value("${api-key}")
    private String apiKey;

    private String prepareURL(String city, String countryISOCode) {
        //get by metric unit & limit data to get 3 days only.
        return String.format("%s?q=%s,%s&appid=%s&units=metric&cnt=24", apiEndPoint, city, countryISOCode, apiKey);
    }

    @Override
    public Optional<WeatherApiResponse> getData(String city, String countryISOCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = prepareURL(city, countryISOCode);
        LOGGER.debug("Fetching from URL: {}", url);
        return Optional.ofNullable(restTemplate.getForObject(url, WeatherApiResponse.class));
    }
}
