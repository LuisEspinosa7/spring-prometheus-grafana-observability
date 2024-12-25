//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.service.impl;

import static com.luisexamples.system.hotelsoccupancy.util.Constants.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisexamples.system.hotelsoccupancy.api.request.ForecastedOccupancyRequest;
import com.luisexamples.system.hotelsoccupancy.entity.ForecastedOccupancyEntity;
import com.luisexamples.system.hotelsoccupancy.metrics.MetricsProcessor;
import com.luisexamples.system.hotelsoccupancy.repository.ForecastedOccupancyRepository;
import com.luisexamples.system.hotelsoccupancy.service.ForecastedOccupancyService;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer.Sample;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class ForecastedOccupancyServiceImpl.
 * 
 * @author luishernan.espinosa
 */
@Slf4j
@Service
public class ForecastedOccupancyServiceImpl implements ForecastedOccupancyService {

	@Autowired
	private ForecastedOccupancyRepository repository;
	
	@Autowired
	private MetricsProcessor metricsProcessor;

	@Override
	public void upsertHotelForecastedOccupancy(ForecastedOccupancyRequest request) {
		Sample timer = metricsProcessor.startTimer();
		List<Tag> tags =
		          Arrays.asList(Tag.of(STEP_TAG_KEY, RETRIEVE_HOTEL_OCCUPANCY_STEP));
		Optional<ForecastedOccupancyEntity> existingEntity = repository.findByHotelCodeAndForecastDate(
				request.getHotelCode(), request.getForecastedOccupancy().getForecastDate());
		metricsProcessor.stopTimer(timer, APPLICATION_STEP_TIMER, APPLICATION_STEP_TIMER_MSG, tags);
		
		ForecastedOccupancyEntity occupancyEntity;
		if (existingEntity.isPresent()) {
			occupancyEntity = existingEntity.get();
			occupancyEntity.setForecastOccupancyPercentage(request.getForecastedOccupancy().getOccupancyPercentage());
		} else {
			occupancyEntity = ForecastedOccupancyEntity.builder()
			.hotelCode(request.getHotelCode())
			.forecastDate(request.getForecastedOccupancy().getForecastDate())
			.forecastOccupancyPercentage(request.getForecastedOccupancy().getOccupancyPercentage())
			.build();
		}
		
		timer = metricsProcessor.startTimer();
		tags =
		          Arrays.asList(Tag.of(STEP_TAG_KEY, UPSERT_HOTEL_OCCUPANCY_STEP));
		repository.save(occupancyEntity);
		metricsProcessor.stopTimer(timer, APPLICATION_STEP_TIMER, APPLICATION_STEP_TIMER_MSG, tags);
	}

}
