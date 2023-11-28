package com.inocomm.service;

import java.util.List;
import java.util.Optional;

import com.inocomm.entity.City;
import com.inocomm.entity.Province;

public interface CityService {

	public List<City> getCityByProvince(Long provinceId);

	public List<City> findCityList();

	public Optional<City> findCityById(Long id);

	public City saveCity(String name, Long provinceId);

	public Optional<City> updateCity(Long id);

	public void deleteCity(Long id);
}
