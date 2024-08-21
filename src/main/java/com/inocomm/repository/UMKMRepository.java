package com.inocomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inocomm.entity.UMKM;

public interface UMKMRepository extends JpaRepository<UMKM, Long>{

	public UMKM save(UMKM umkm);

}
