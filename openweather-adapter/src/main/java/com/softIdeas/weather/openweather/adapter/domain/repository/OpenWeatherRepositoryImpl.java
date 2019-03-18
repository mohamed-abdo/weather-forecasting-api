package com.softIdeas.weather.openweather.adapter.domain.repository;

import com.softIdeas.weather.openweather.adapter.domain.model.forecastWeather.WeatherAPIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherRepositoryImpl implements OpenWeatherRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherRepositoryImpl.class);
    @Value("${api-endpoint}")
    private String apiEndPoint;

    @Value("${api-key}")
    private String apiKey;

    private String prepareURL(String city, String countryISOCode) {
        //get by metric unit & limit data to get 3 days only.
        return String.format("%s?q=%s,%s&appid=%s&units=metric&cnt=24", apiEndPoint, city, countryISOCode, apiKey);
    }

    @Override
    public WeatherAPIResponse getData(String city, String countryISOCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = prepareURL(city, countryISOCode);
        LOGGER.debug("URL: {}", url);
        return restTemplate.getForObject(url, WeatherAPIResponse.class);
    }
}
