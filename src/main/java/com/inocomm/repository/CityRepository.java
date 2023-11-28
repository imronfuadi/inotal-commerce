package com.inocomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inocomm.entity.City;
import com.inocomm.entity.Province;

public interface CityRepository extends JpaRepository<City, Long>{

	List<City> findByProvinceId(Long provinceId);

//	City save(City city, Long provinceId);
}
