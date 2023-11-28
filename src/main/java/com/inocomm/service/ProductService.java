package com.inocomm.service;

import java.util.List;
import java.util.Optional;

import com.inocomm.dto.ProductCreateRequestDTO;
import com.inocomm.dto.ProductListResponseDTO;
import com.inocomm.dto.ProductUpdateRequestDTO;
import com.inocomm.entity.Product;

public interface ProductService {

	//TANPA DTO
	//get all data
	public List<Product> findProductListDetail();
	
	public Optional<Product> findProductByid(Long id);
	
	//add data
	public Product saveProduct(Product product);
	
	//get data by id
	public Optional<Product> updateProduct(Long id);
	
	//delete data
	public void deleteProduct(Long id);
	
	
	//Dengan DTO
//	public List<ProductListResponseDTO> findProductListDetail();
//
//	public void createNewProduct(ProductCreateRequestDTO dto);
//
//	public void updateProduct(Long productId, ProductUpdateRequestDTO dto);
//
//	public void deleteProduct(Long productId);
}
