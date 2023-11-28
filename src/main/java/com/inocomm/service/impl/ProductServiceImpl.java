package com.inocomm.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inocomm.dto.ProductCreateRequestDTO;
import com.inocomm.dto.ProductListResponseDTO;
import com.inocomm.dto.ProductUpdateRequestDTO;
import com.inocomm.entity.Product;
import com.inocomm.repository.ProductRepository;
import com.inocomm.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
//
//	@Override
//	public List<ProductListResponseDTO> findProductListDetail() {
//		List<Product> products = productRepository.findAll();
//		return products.stream().map((p)->{
//			ProductListResponseDTO dto = new ProductListResponseDTO();
//			dto.setProductId(p.getId());
//			dto.setProductName(p.getProductName());
//			dto.setProductPrice(p.getPrice());
//			dto.setProductQuantity(p.getQuantity());
//			dto.setProductPict(p.getPict());
//			dto.setProductDescription(p.getDescription());
//			return dto;
//		}).collect(Collectors.toList());
//	}
//
//	@Override
//	public void createNewProduct(ProductCreateRequestDTO dto) {
//		Product product = new Product();
//		product.setProductName(dto.getProductName());
//		product.setPrice(dto.getProductPrice());
//		product.setQuantity(dto.getProductQuantity());
//		product.setDescription(dto.getProductDescription());
//		product.setPict(dto.getProductPict());
//		productRepository.save(product);
//	}
//
//	@Override
//	public void updateProduct(Long productId, ProductUpdateRequestDTO dto) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteProduct(Long productId) {
////		Product product = productRepository.findById(productId).orElse(new Product());
//		productRepository.deleteById(productId);
//	}
	
	//TANPA DTO
	@Override
	public List<Product> findProductListDetail() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> updateProduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);;
	}

	@Override
	public Optional<Product> findProductByid(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}




}
