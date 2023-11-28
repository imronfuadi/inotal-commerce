package com.inocomm.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductUpdateRequestDTO {

	@NotBlank
	private String productName;
	@NotBlank
	private Long productPrice;
	@NotBlank
	private String productPict;
	@NotBlank
	private Long productQuantity;
	
	private String productDescription;
}
