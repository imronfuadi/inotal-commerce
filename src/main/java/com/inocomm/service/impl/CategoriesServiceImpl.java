package com.inocomm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inocomm.entity.Categories;
import com.inocomm.repository.CategoriesRepository;
import com.inocomm.service.CategoriesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriesServiceImpl implements CategoriesService{

	private CategoriesRepository categoriesRepository;
	
	@Override
	public List<Categories> findAllCategories() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll();
	}

}
