package com.inocomm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductListResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -125050939596101660L;

	private Long productId;
	
	private String productName;
	
	private Long productPrice;
	
	private String productPict;
	
	private Long productQuantity;
	
	private String productDescription;
}
