package com.inocomm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductCreateRequestDTO {
	
	@NotBlank
	private String productName;
	
	private Long productPrice;
	
	private String productPict;
	
	private Long productQuantity;
	
	private String productDescription;
}
