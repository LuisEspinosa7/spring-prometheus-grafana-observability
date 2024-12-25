//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ForecastedOccupancyEntity.
 * 
 * @author luishernan.espinosa
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "forecasted_hotel_occupancy")
public class ForecastedOccupancyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "hotel_code")
	private String hotelCode;

	@Column(name = "forecast_date")
	private LocalDate forecastDate;

	@Column(name = "forecast_occupancy_percentage")
	private BigDecimal forecastOccupancyPercentage;

	@UpdateTimestamp
	@Column(name = "last_updated")
	private Instant lastUpdated;

}
