package com.sami.reactive.app.service.imp;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sami.reactive.app.models.request.LambdaFileRequest;
import com.sami.reactive.app.service.LambdaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LambdaServiceImpl implements LambdaService {

	@Autowired
	private AWSLambda awsLambda;
	
	@Override
	public Boolean uploadFileLambda(LambdaFileRequest request) {
		log.info("LambdaServiceImpl.obtenerBase64 {}", request);
		try {
			Gson gson = new Gson();
			String payLoad = gson.toJson(request);
			InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("lambda-test")
					.withPayload(payLoad);
			InvokeResult result = awsLambda.invoke(invokeRequest);
			String ans = new String(result.getPayload().array(), StandardCharsets.UTF_8);
			Boolean respuesta = Boolean.parseBoolean(ans);
			return respuesta;	
		} catch (Exception e) {
			log.error("Error al CArgar el archivo con la Lambda {}", e);
			return false;
		}
	}

}
