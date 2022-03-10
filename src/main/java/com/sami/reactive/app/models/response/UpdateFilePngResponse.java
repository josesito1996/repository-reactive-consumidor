package com.sami.reactive.app.models.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
@Setter
@ToString
public class UpdateFilePngResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6546248794525016639L;

	private String id;
	
	private String url;
}
