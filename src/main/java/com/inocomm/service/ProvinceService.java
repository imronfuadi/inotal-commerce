package com.inocomm.service;

import java.util.List;
import java.util.Optional;

import com.inocomm.entity.Province;

public interface ProvinceService {

	public List<Province> findProvinceList();
	
	public Optional<Province> findProvinceById(Long id);
	
	public Province saveProvince(Province province);
	
	public Optional<Province> updateProvince(Long id);
	
	public void deleteProvince(Long id);
}
