//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisexamples.system.hotelsoccupancy.entity.ForecastedOccupancyEntity;

/**
 * The Interface ForecastedOccupancyRepository.
 * 
 * @author luishernan.espinosa
 */
@Repository
public interface ForecastedOccupancyRepository 
	extends JpaRepository<ForecastedOccupancyEntity, Long> {
	
	Optional<ForecastedOccupancyEntity> findByHotelCodeAndForecastDate(String hotelCode,
		      LocalDate forecastDate);
	
}
