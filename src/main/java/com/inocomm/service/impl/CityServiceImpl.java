package com.inocomm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inocomm.entity.City;
import com.inocomm.entity.Province;
import com.inocomm.repository.CityRepository;
import com.inocomm.repository.ProvinceRepository;
import com.inocomm.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Override
	@ResponseBody
	public List<City> getCityByProvince(@RequestParam Long provinceId) {
		return cityRepository.findByProvinceId(provinceId);
	}

	@Override
	public List<City> findCityList() {
		// TODO Auto-generated method stub
		return cityRepository.findAll();
	}

	@Override
	public Optional<City> findCityById(Long id) {
		// TODO Auto-generated method stub
		return cityRepository.findById(id);
	}

	@Override
	public City saveCity(String name, Long provinceId) {
		// TODO Auto-generated method stub
		// Ambil objek Provinsi dari repository
        Province province= provinceRepository.findById(provinceId).orElseThrow();
        
     // Buat objek Kota baru
        City city= new City();
        city.setName(name);
        city.setProvince(province);
		return cityRepository.save(city);
	}

	@Override
	public Optional<City> updateCity(Long id) {
		// TODO Auto-generated method stub
		return cityRepository.findById(id);
	}

	@Override
	public void deleteCity(Long id) {
		// TODO Auto-generated method stub
		cityRepository.deleteById(id);
	}


}
