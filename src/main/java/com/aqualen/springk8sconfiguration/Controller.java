package com.aqualen.springk8sconfiguration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

  private final Properties properties;

  @GetMapping("objects")
  ResponseEntity<String> getObjects() {
    return ResponseEntity.ok().body(
        String.format("There are objects of type: %s with colors: %s.",
            properties.getObjectName(), String.join(", ", properties.getColors())));
  }

}
