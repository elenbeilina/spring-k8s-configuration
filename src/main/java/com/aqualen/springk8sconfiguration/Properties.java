package com.aqualen.springk8sconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "spring-k8s-configuration")
public class Properties {
  private String objectName;
  private List<String> colors;
}
