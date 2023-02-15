package com.aqualen.springk8sconfiguration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SpringK8sConfigurationApplication {

  private final Properties properties;

  public static void main(String[] args) {
    SpringApplication.run(SpringK8sConfigurationApplication.class, args);
  }

  @EventListener(ApplicationStartedEvent.class)
  public void logProperties() {
    log.info("There are objects of type: {} with colors: {}.",
        properties.getObjectName(), String.join(", ", properties.getColors()));
  }
}
