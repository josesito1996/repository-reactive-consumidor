package com.sami.reactive.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sami.reactive.app.models.request.SaveContractRequest;
import com.sami.reactive.app.models.response.SaveContractResponse;
import com.sami.reactive.app.service.ContratoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api-resource-sami")
public class ContratoController {

	@Autowired
	private ContratoService service;
	
	@PostMapping(path = "/saveContractResource")
	public Mono<SaveContractResponse> saveContractResource(@RequestBody SaveContractRequest request){
		return service.saveContract(request);
	}
	
}
