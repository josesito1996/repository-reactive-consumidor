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
public class UpdateContractUrlRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7882429833634243610L;
	
	private String id;
	
	private String url;
}
