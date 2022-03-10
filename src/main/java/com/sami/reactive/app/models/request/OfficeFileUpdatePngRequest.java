package com.sami.reactive.app.models.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class OfficeFileUpdatePngRequest implements Serializable {
	
	private static final long serialVersionUID = -1935281838025248564L;
	
	private String idArchivo;
	
	private String nombreArchivo;
	
	private String type;
	
	private String bucketName;
}
