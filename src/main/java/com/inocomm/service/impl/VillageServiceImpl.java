package com.inocomm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inocomm.entity.City;
import com.inocomm.entity.Province;
import com.inocomm.entity.Subdistrict;
import com.inocomm.entity.Village;
import com.inocomm.repository.CityRepository;
import com.inocomm.repository.ProvinceRepository;
import com.inocomm.repository.SubdistrictRepository;
import com.inocomm.repository.VillageRepository;
import com.inocomm.service.VillageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VillageServiceImpl implements VillageService{

	@Autowired
	public final VillageRepository villageRepository;
	
	@Autowired
	public final SubdistrictRepository subdistrictRepository;

	@Autowired
	public final ProvinceRepository provinceRepository;

	@Autowired
	public final CityRepository cityRepository;
	
	@Override
	public List<Village> getVillageBySubdistrict(Long subdistrictId) {
		// TODO Auto-generated method stub
		return villageRepository.findBySubdistrictId(subdistrictId);
	}

	@Override
	public List<Village> findVillageList() {
		// TODO Auto-generated method stub
		return villageRepository.findAll();
	}

	@Override
	public Optional<Village> findVillageById(Long id) {
		// TODO Auto-generated method stub
		return villageRepository.findById(id);
	}

	@Override
	public Village saveVillage(String name, Long provinceId, Long cityId, Long subdistrictId) {
		// TODO Auto-generated method stub
		Province province = provinceRepository.findById(provinceId).orElseThrow();
		City city = cityRepository.findById(cityId).orElseThrow();
		Subdistrict subdistrict = subdistrictRepository.findById(subdistrictId).orElseThrow();
		
		Village village = new Village();
		village.setName(name);
		village.setProvince(province);
		village.setCity(city);
		village.setSubdistrict(subdistrict);
		
		return villageRepository.save(village);
	}

	@Override
	public Optional<Village> updateVillage(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteVillage(Long id) {
		// TODO Auto-generated method stub
		
	}

}
