package com.inocomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inocomm.entity.Subdistrict;

public interface SubdistrictRepository extends JpaRepository<Subdistrict, Long> {

	List<Subdistrict> findByCityId(Long cityId);
}
