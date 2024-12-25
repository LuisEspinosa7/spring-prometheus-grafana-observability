//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.context;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RequestContextImpl.
 * 
 * @author luishernan.espinosa
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
public class RequestContextImpl implements Serializable, RequestContext {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 5505851967310478024L;
  
  private String trackingId;
  
  private String requestor;
  
  private String operationName;

  
}
