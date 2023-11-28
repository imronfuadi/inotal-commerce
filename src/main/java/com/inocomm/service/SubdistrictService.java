package com.inocomm.service;

import java.util.List;
import java.util.Optional;

import com.inocomm.entity.Subdistrict;

public interface SubdistrictService {

	public List<Subdistrict> getSubdistrictByCity(Long cityId);
	
	public List<Subdistrict> findSubdistricList();
	
	public Optional<Subdistrict> findSubdistrictById(Long id);
	
	public Subdistrict saveSubdistrict(String name, Long provinceId, Long cityId);

	public Optional<Subdistrict> updateSubdistrict(Long id);

	public void deleteSubdistrict(Long id);
}
