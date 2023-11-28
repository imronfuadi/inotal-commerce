package com.inocomm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inocomm.entity.Province;
import com.inocomm.repository.ProductRepository;
import com.inocomm.repository.ProvinceRepository;
import com.inocomm.service.ProvinceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Override
	public List<Province> findProvinceList() {
		// TODO Auto-generated method stub
		return provinceRepository.findAll();
	}

	@Override
	public Optional<Province> findProvinceById(Long id) {
		// TODO Auto-generated method stub
		return provinceRepository.findById(id);
	}

	@Override
	public Province saveProvince(Province province) {
		// TODO Auto-generated method stub
		return provinceRepository.save(province);
	}

	@Override
	public Optional<Province> updateProvince(Long id) {
		// TODO Auto-generated method stub
		return provinceRepository.findById(id);
	}

	@Override
	public void deleteProvince(Long id) {
		// TODO Auto-generated method stub
		provinceRepository.deleteById(id);
	}

}
