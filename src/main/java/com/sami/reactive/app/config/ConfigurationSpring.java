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
	
	@Value("${service.http.process-file-url}")
	private String officeEndpoint;

	@Bean(name = "beanSamiPrimary")
	public WebClient getWebClient(WebClient.Builder webClientBuilder) {
		log.info("primaryEndpoint {}", primaryEndpoint);
		return webClientBuilder.baseUrl(primaryEndpoint).build();
	};
	
	@Bean(name = "beanSamiOffice")
	public WebClient getWebClientOffice(WebClient.Builder webClientBuilder) {
		log.info("primaryEndpoint {}", officeEndpoint);
		return webClientBuilder.baseUrl(officeEndpoint).build();
	};

}
