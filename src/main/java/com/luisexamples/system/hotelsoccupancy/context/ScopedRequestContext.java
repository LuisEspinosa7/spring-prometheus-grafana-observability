//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.context;

import static com.luisexamples.system.hotelsoccupancy.util.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ScopedRequestContext.
 * 
 * @author luishernan.espinosa
 */
@Getter
@Setter
@Component
@RequestScope
@SuppressWarnings("serial")
public class ScopedRequestContext extends RequestContextImpl {
  public ScopedRequestContext(@Autowired HttpServletRequest request) {
    super(request.getHeader(TRACKING_ID_NAME),
        request.getHeader(REQUESTOR_NAME), null);
  }
}
