package com.solo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenAPI3Configuration {
  
  @Value("${swagger.api-gateway-url}")
  private String apiGatewayUrl;

  @Value("${spring.application.name}")
  private String name;

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
      .info(new Info()
        .title(name + " Service APIs")
        .description("App " + name + " Service APIs")
        .version("v1.0.0")
        .contact(new Contact().name("HIEDU").url(apiGatewayUrl)))
      .servers(List.of(new Server().url(apiGatewayUrl)));
  }
}
