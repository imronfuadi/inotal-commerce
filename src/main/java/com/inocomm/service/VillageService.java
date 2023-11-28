package com.inocomm.service;

import java.util.List;
import java.util.Optional;

import com.inocomm.entity.Village;

public interface VillageService {


	public List<Village> getVillageBySubdistrict(Long subdistrictId);
	
	public List<Village> findVillageList();
	
	public Optional<Village> findVillageById(Long id);
	
	public Village saveVillage(String name, Long provinceId, Long cityId, Long subdistrictId);

	public Optional<Village> updateVillage(Long id);

	public void deleteVillage(Long id);
}
