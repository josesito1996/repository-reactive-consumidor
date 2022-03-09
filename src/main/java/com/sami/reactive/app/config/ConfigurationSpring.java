package com.sami.reactive.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ConfigurationSpring {

	@Value("${service.http.primary-url}")
	private String primaryEndpoint;

	@Bean(name = "beanSamiPrimary")
	public WebClient getWebClient(WebClient.Builder webClientBuilder) {
		log.info("primaryEndpoint {}", primaryEndpoint);
		return webClientBuilder.baseUrl(primaryEndpoint).build();
	};

}
