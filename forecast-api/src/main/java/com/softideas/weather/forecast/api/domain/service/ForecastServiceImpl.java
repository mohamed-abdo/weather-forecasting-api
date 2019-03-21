package com.softideas.weather.forecast.api.domain.service;

import com.softideas.common.aspects.statistics.Info;
import com.softideas.common.aspects.validation.Validate;
import com.softideas.common.aspects.validation.ValidatorException;
import com.softideas.weather.forecast.api.domain.model.DayShift;
import com.softideas.weather.forecast.api.domain.model.ForecastData;
import com.softideas.weather.forecast.api.domain.model.WeatherForecast;
import com.softideas.weather.openweather.forecast.adapter.domain.model.List;
import com.softideas.weather.openweather.forecast.adapter.domain.repository.OpenWeatherApiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastServiceImpl.class);

    @Autowired
    private OpenWeatherApiRepository openWeatherAPIRepository;
    private static final DecimalFormat df2 = new DecimalFormat(".##");

    @Info
    @Validate(parameterName = "city", test = ValidateIForecastServiceImpl.class)
    @Override
    public Optional<WeatherForecast> forecastWeather(String city, String country) throws ValidatorException {
        LOGGER.info("receive service request: {}, {}", city, country);

        return openWeatherAPIRepository.getData(city, country).map(data -> {
            //group by morning & evening then get average of grouped data
            Stream<Map.Entry<DayShift, java.util.List<List>>> entries = data.getList().stream().collect(
                    Collectors.groupingBy(d -> getDayShift.apply(d.getDt())))
                    .entrySet().stream();
            Set<Map.Entry<ForecastData, java.util.List<List>>> groupedForecast = entries.collect(Collectors.toMap(x -> {
                Double tempAvg = x.getValue().stream().mapToDouble(f -> f.getMain().getTemp()).average().orElse(0D);
                Double pressAvg = x.getValue().stream().mapToDouble(f -> f.getMain().getPressure()).average().orElse(0D);
                return new ForecastData.Builder()
                        .setMorningAverageTemperature(x.getKey())
                        .setAverageTemperature(tempAvg)
                        .setPressureAverageTemperature(pressAvg)
                        .build();
            }, Map.Entry::getValue)).entrySet();
            AtomicReference<WeatherForecast> weatherForecastAtomicReference = new AtomicReference<>();
            java.util.List<ForecastData> forecastDataList = groupedForecast.stream().map(d -> d.getKey())
                    .collect(Collectors.toList());
            WeatherForecast weatherForecast = new WeatherForecast();
            for (ForecastData forecastData : forecastDataList) {
                switch (forecastData.getDayShift()) {
                    case DayTime:
                        weatherForecast.setMorningTemperature(df2.format(forecastData.getAverageTemperature()));
                        break;
                    case NightTime:
                        weatherForecast.setNightTemperature(df2.format(forecastData.getAverageTemperature()));
                        break;
                }
                weatherForecast.setPressure(df2.format(forecastData.getPressureAverageTemperature()));
            }
            return weatherForecast;
        });
    }

    private Function<Long, DayShift> getDayShift = (epochMilli) -> {
        LocalTime timeStamp = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochMilli), ZoneOffset.UTC).toLocalTime();

        if (timeStamp.compareTo(LocalTime.of(6, 0)) == 0 ||
                (timeStamp.isAfter(LocalTime.of(6, 0)) &&
                        timeStamp.isBefore(LocalTime.of(18, 0))))
            return DayShift.DayTime;
        return DayShift.NightTime;
    };
}
