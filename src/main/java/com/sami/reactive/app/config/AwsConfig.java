package com.sami.reactive.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;

@Configuration
public class AwsConfig {

	@Value("${aws.config.region}")
	private String region;

	@Value("${aws.config.access-key}")
	private String accessKey;

	@Value("${aws.config.secret-key}")
	private String secretKey;

	@Value("${aws.config.service-endpoint}")
	private String serviceEnpoint;

	public AWSCredentialsProvider awsCredentialsProvider() {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
	}

	@Bean
	public AWSLambda getAwsLambda() {
		return AWSLambdaClientBuilder.standard().withCredentials(awsCredentialsProvider()).withRegion(Regions.US_EAST_2)
				.build();
	}

}
