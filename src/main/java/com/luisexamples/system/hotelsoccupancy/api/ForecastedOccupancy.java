//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.api;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class HotelOccupancy.
 * 
 * @author luishernan.espinosa
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForecastedOccupancy {
	
	private LocalDate forecastDate;
	
	private BigDecimal occupancyPercentage;
	
}
