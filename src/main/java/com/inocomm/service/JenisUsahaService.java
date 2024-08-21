package com.inocomm.service;

import java.util.List;
import java.util.Optional;

import com.inocomm.entity.JenisUsaha;

public interface JenisUsahaService {

	public List<JenisUsaha> findAllJenisUsaha();
	
	public JenisUsaha saveJenisUsaha(JenisUsaha jenisUsaha);
	
	public Optional<JenisUsaha> updateJenisUsaha(Long id);
	
	public void deleteJenisUsaha(Long id);
}
