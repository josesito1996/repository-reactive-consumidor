package com.sami.reactive.app.service;

import com.sami.reactive.app.models.request.LambdaFileRequest;

public interface LambdaService {

	Boolean uploadFileLambda(LambdaFileRequest request);
	
}
