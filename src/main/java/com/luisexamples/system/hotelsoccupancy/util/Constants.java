//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.util;

/**
 * The Interface Constants.
 * 
 * @author luishernan.espinosa
 */
public interface Constants {
	
	 String QUALIFIER_TAG_KEY = "qualifier";
	  String ENVIRONMENT_TAG_KEY = "environment";
	  String APPLICATION_TAG_KEY = "application";
	  String REQUESTOR_TAG_KEY = "requestor";
	  String OPERATION_TAG_KEY = "operation";
	  String STEP_TAG_KEY = "step";

	  String QUALIFIER_ENV_KEY = "QUALIFIER";
	  String ENVIRONMENT_ENV_KEY = "ENVIRONMENT";
	  String APPLICATION_ENV_KEY = "APPLICATION_NAME";
	  String UNKNOWN_ENV_PROPERTY = "UNKNOWN";
	  
	  String REQUESTOR_NAME = "X-Requestor";
	  String TRACKING_ID_NAME = "X-TrackingId";
	  
	  String UPSERT_HOTEL_OCCUPANCY_OPERATION = "UPSERT_HOTEL_OCCUPANCY_OPERATION";
	  String APPLICATION_STEP_TIMER = "application.step.timer";
	  String APPLICATION_STEP_TIMER_MSG = "Step timer";
	  
	  String RETRIEVE_HOTEL_OCCUPANCY_STEP = "RETRIEVE_HOTEL_OCCUPANCY_STEP";
	  String UPSERT_HOTEL_OCCUPANCY_STEP = "UPSERT_HOTEL_OCCUPANCY_STEP";
}
