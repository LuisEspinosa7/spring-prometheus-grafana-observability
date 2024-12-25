//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.service;

import com.luisexamples.system.hotelsoccupancy.api.request.ForecastedOccupancyRequest;

/**
 * The Class ForecastedOccupancyService.
 * 
 * @author luishernan.espinosa
 */
public interface ForecastedOccupancyService {

	public void upsertHotelForecastedOccupancy(ForecastedOccupancyRequest request);

}
