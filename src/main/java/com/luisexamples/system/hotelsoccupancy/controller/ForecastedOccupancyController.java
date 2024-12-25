package com.luisexamples.system.hotelsoccupancy.controller;

import static com.luisexamples.system.hotelsoccupancy.util.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisexamples.system.hotelsoccupancy.api.request.ForecastedOccupancyRequest;
import com.luisexamples.system.hotelsoccupancy.context.ScopedRequestContext;
import com.luisexamples.system.hotelsoccupancy.service.ForecastedOccupancyService;

@RequestMapping(value = "/v1/hotel")
@RestController
public class ForecastedOccupancyController {
	
	@Autowired
	private ScopedRequestContext context;
	
	@Autowired
	private ForecastedOccupancyService service;
	
	@PutMapping("/occupancy")
	public ResponseEntity<Void> upsertHotelForecastedOccupancy(
			@RequestHeader(value = TRACKING_ID_NAME) String trackingId,
			@RequestHeader(value = REQUESTOR_NAME) String requestor,
			@RequestBody ForecastedOccupancyRequest request){
		context.setOperationName(UPSERT_HOTEL_OCCUPANCY_OPERATION);
		service.upsertHotelForecastedOccupancy(request);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
