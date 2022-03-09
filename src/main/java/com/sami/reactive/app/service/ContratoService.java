package com.sami.reactive.app.service;

import com.sami.reactive.app.models.request.SaveContractRequest;
import com.sami.reactive.app.models.response.SaveContractResponse;

import reactor.core.publisher.Mono;

public interface ContratoService {

	Mono<SaveContractResponse> saveContract(SaveContractRequest request);
	
}
