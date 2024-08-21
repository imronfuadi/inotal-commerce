package com.inocomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inocomm.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{

	public List<Categories> findAll();
}
