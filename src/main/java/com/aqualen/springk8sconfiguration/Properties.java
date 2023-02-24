package com.aqualen.springk8sconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring-k8s-configuration")
public class Properties {
  private String objectName;
  private List<String> colors;
}
