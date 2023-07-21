package com.example.httpclient.config;

import com.example.httpclient.services.UserClient;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {
    @Bean
  WebClient webClient() {
    return WebClient.builder()
        .baseUrl("https://dummyjson.com/")
        .build();
  }

  @SneakyThrows
  @Bean
  UserClient postClient(WebClient webClient) {
    HttpServiceProxyFactory httpServiceProxyFactory =
        HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
            .build();
    return httpServiceProxyFactory.createClient(UserClient.class);
  }
}