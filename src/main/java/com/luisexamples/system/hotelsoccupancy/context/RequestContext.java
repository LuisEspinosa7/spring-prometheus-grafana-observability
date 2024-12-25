//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.context;

/**
 * Interface for each application context.
 * 
 * @author luishernan.espinosa
 */
public interface RequestContext {
	  /**
	   * Returns the unique client identifier supplied to the execution of a request.
	   *
	   * @return the value of the client identifier.
	   */
	  String getRequestor();

	  /**
	   * Returns the request identifier supplied to the execution of a request by a client.
	   *
	   * @return the value of the client request identifier.
	   */
	  String getTrackingId();


	  /**
	   * Returns the operation Name.
	   *
	   * @return The operation Name
	   */
	  String getOperationName();

	}

