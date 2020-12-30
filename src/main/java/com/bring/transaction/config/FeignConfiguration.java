package com.bring.transaction.config;

import com.bring.transaction.client.openapi.OpenApiClient;
import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Feign configuration
 */
@Configuration
@Import({FeignClientsConfiguration.class})
@EnableFeignClients(clients = {OpenApiClient.class})
public class FeignConfiguration {

  @Bean
  public Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  public Logger feignLogger() {
    return new Slf4jLogger();
  }
}
