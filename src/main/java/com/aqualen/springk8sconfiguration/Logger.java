package com.aqualen.springk8sconfiguration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("log")
@RequiredArgsConstructor
public class Logger {

  private final Properties properties;

  @EventListener(ApplicationStartedEvent.class)
  public void logProperties() {
    log.info("There are objects of type: {} with colors: {}.",
        properties.getObjectName(), String.join(", ", properties.getColors()));
  }
}
