package com.sami.reactive.app.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class SaveContractResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7114997284901318963L;

	private String idFile;

	@JsonInclude(Include.NON_NULL)
	private String idFileExtension;

	@JsonInclude(Include.NON_NULL)
	private String nombreArchivo;

	@JsonInclude(Include.NON_NULL)
	private String categoria;

	@JsonInclude(Include.NON_NULL)
	private String description;

	@JsonInclude(Include.NON_NULL)
	private String base64;

	@JsonInclude(Include.NON_NULL)
	private String upLoadDate;

	@JsonInclude(Include.NON_NULL)
	private String type;

	@JsonInclude(Include.NON_NULL)
	private Boolean esUtil;

	@JsonInclude(Include.NON_NULL)
	private Boolean esFavorito;

	@JsonInclude(Include.NON_NULL)
	private String url;
}
