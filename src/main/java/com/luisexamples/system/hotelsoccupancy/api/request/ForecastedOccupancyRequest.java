//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.api.request;

import com.luisexamples.system.hotelsoccupancy.api.ForecastedOccupancy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ForecastedOccupancyRequest.
 * 
 * @author luishernan.espinosa
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForecastedOccupancyRequest {

	private String hotelCode;

	private ForecastedOccupancy forecastedOccupancy;

}
