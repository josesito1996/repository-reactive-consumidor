package com.sami.reactive.app.service.imp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sami.reactive.app.models.request.FileRequestBody;
import com.sami.reactive.app.models.request.LambdaFileRequest;
import com.sami.reactive.app.models.request.SaveContractRequest;
import com.sami.reactive.app.models.response.SaveContractResponse;
import com.sami.reactive.app.service.ContratoService;
import com.sami.reactive.app.service.LambdaService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	@Qualifier("beanSamiPrimary")
	private WebClient webClientContrato;
	
	@Autowired
	private LambdaService lambdaService;

	@Override
	public Mono<SaveContractResponse> saveContract(SaveContractRequest request) {
		log.info("ContratoServiceImpl.saveContract");
		log.info("SaveContractRequest {}", request);
		String base64 = request.getBase64();
		request.setBase64(null);
		return webClientContrato.post().uri("api-resource-sami/saveContract")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(request), SaveContractRequest.class).retrieve().bodyToMono(SaveContractResponse.class)
				.doOnError(error -> log.error("Error al llamar al servicio {}", error))
				.subscribeOn(Schedulers.parallel())
				.doOnSuccess(resp -> {
					log.info("Lambda Upload {}", lambdaService.uploadFileLambda(LambdaFileRequest.builder()
							.httpMethod("POST")
							.requestBody(Arrays.asList(FileRequestBody.builder()
									.idFile(resp.getIdFile())
									.nombreArchivo(resp.getNombreArchivo())
									.base64(base64)
									.build()))
							.bucketName("contratos-samy")
							.build()));
				});
	}

}
