//Copyright 2024 Luis Hernan Espinosa
package com.luisexamples.system.hotelsoccupancy.metrics;

import static com.luisexamples.system.hotelsoccupancy.util.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.luisexamples.system.hotelsoccupancy.context.ScopedRequestContext;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.Timer.Builder;
import io.micrometer.core.instrument.Timer.Sample;

/**
 * The Class MetricsProcessor.
 * 
 * @author luishernan.espinosa
 */
@Component
public class MetricsProcessor {

  @Autowired
  private MeterRegistry meterRegistry;

  @Autowired
  private Environment environment;

  @Autowired
  private ScopedRequestContext requestContext;

  /**
   * If tag exists in the environment add it to List
   *
   * @return List of tags
   */
  private List<Tag> getMetricTags() {
    return Arrays.asList(
        Tag.of(QUALIFIER_TAG_KEY,
            Optional.ofNullable(environment.getProperty(QUALIFIER_ENV_KEY))
                .orElse(UNKNOWN_ENV_PROPERTY)),
        Tag.of(ENVIRONMENT_TAG_KEY,
            Optional.ofNullable(environment.getProperty(ENVIRONMENT_ENV_KEY))
                .orElse(UNKNOWN_ENV_PROPERTY)),
        Tag.of(APPLICATION_TAG_KEY,
            Optional.ofNullable(environment.getProperty(APPLICATION_ENV_KEY))
                .orElse(UNKNOWN_ENV_PROPERTY)),
        Tag.of(OPERATION_TAG_KEY,
            Optional.ofNullable(requestContext.getOperationName())
                .orElse(UNKNOWN_ENV_PROPERTY)),
        Tag.of(REQUESTOR_TAG_KEY,
            Optional.ofNullable(requestContext.getRequestor())
                .orElse(UNKNOWN_ENV_PROPERTY)));
  }


  /**
   * Increment counter with description
   * 
   * @param counterName
   * @param counterDescription
   * @param operationName
   * @param requestor
   */
  public void incrementCounter(String counterName, String counterDescription) {

    Counter counter = Counter.builder(counterName)
    		.description(counterDescription)
    		.tags(getMetricTags())
    		.register(meterRegistry);

    counter.increment();
  }

  /**
   * Starts a timer. Timers also record counts.
   *
   * @return a timer
   */
  public Sample startTimer() {
    return Timer.start(meterRegistry);
  }

  /**
   * Stops a timer.
   *
   * @param timer the timer
   * @param name the name of the timer
   * @param tags the metric tags
   */
  public void stopTimer(Sample timer, String name, String description, List<Tag> tags) {
    Builder timerBuilder = Timer.builder(name).description(description);

    timerBuilder.tags(mergeTags(getMetricTags(), tags));

    Timer taggedTimer = timerBuilder.register(meterRegistry);
    timer.stop(taggedTimer);
  }
  
  /**
   * Merge all tags, existing and provided to be overriden.
   *
   * @param existingTags the existing tags
   * @param providedTags the provided tags
   * @return the complete list of tags
   */
  private List<Tag> mergeTags(List<Tag> existingTags, List<Tag> providedTags){
    Map<String, String> existingTagsMap = existingTags.stream()
        .collect(Collectors.toMap(Tag::getKey, Tag::getValue));
    
    if (CollectionUtils.isNotEmpty(providedTags)) {
      for (Tag tag : providedTags) {
        existingTagsMap.put(tag.getKey(), tag.getValue());
      }
    }
    
    List<Tag> mergedTags = new ArrayList<>();
    for (Map.Entry<String, String> existingTag : existingTagsMap.entrySet()) {
      mergedTags.add(Tag.of(existingTag.getKey(), existingTag.getValue()));
    }
    
    return mergedTags;
  }
}
