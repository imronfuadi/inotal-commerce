package com.inocomm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inocomm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Optional<Product> findById(Long id);
	
	public List<Product> findAll();
	
	//public void save(Product product);
	
}
