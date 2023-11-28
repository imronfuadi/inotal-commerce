package com.inocomm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inocomm.entity.City;
import com.inocomm.entity.Province;
import com.inocomm.entity.Subdistrict;
import com.inocomm.repository.CityRepository;
import com.inocomm.repository.ProvinceRepository;
import com.inocomm.repository.SubdistrictRepository;
import com.inocomm.service.SubdistrictService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubdistrictServiceImpl implements SubdistrictService {

	@Autowired
	public final SubdistrictRepository subdistrictRepository;

	@Autowired
	public final ProvinceRepository provinceRepository;

	@Autowired
	public final CityRepository cityRepository;

	@Override
	public List<Subdistrict> getSubdistrictByCity(Long cityId) {
		// TODO Auto-generated method stub
		return subdistrictRepository.findByCityId(cityId);
	}

	@Override
	public List<Subdistrict> findSubdistricList() {
		// TODO Auto-generated method stub
		return subdistrictRepository.findAll();
	}

	@Override
	public Optional<Subdistrict> findSubdistrictById(Long id) {
		// TODO Auto-generated method stub
		return subdistrictRepository.findById(id);
	}

	@Override
	public Subdistrict saveSubdistrict(String name, Long provinceId, Long cityId) {
		// TODO Auto-generated method stub
		Province province = provinceRepository.findById(provinceId).orElseThrow();
		City city = cityRepository.findById(cityId).orElseThrow();

		Subdistrict subdistrict = new Subdistrict();
		subdistrict.setName(name);
		subdistrict.setCity(city);
		subdistrict.setProvince(province);
		
		return subdistrictRepository.save(subdistrict);
	}

	@Override
	public Optional<Subdistrict> updateSubdistrict(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteSubdistrict(Long id) {
		// TODO Auto-generated method stub

	}

}
