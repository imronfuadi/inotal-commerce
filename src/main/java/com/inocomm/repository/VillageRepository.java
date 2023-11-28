package com.inocomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inocomm.entity.Village;

public interface VillageRepository extends JpaRepository<Village, Long>{

	List<Village> findBySubdistrictId(Long subdistrictId);
}
