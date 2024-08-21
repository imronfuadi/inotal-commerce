package com.inocomm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inocomm.entity.JenisUsaha;
import com.inocomm.repository.JenisUsahaRepository;
import com.inocomm.service.JenisUsahaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JenisUsahaServiceImpl implements JenisUsahaService{

	@Autowired
	private final JenisUsahaRepository jenisUsahaRepository;
	
	@Override
	public List<JenisUsaha> findAllJenisUsaha() {
		// TODO Auto-generated method stub
		return jenisUsahaRepository.findAll();
	}

	@Override
	public JenisUsaha saveJenisUsaha(JenisUsaha jenisUsaha) {
		// TODO Auto-generated method stub
		return jenisUsahaRepository.save(jenisUsaha);
	}

	@Override
	public Optional<JenisUsaha> updateJenisUsaha(Long id) {
		// TODO Auto-generated method stub
		return jenisUsahaRepository.findById(id);
	}

	@Override
	public void deleteJenisUsaha(Long id) {
		// TODO Auto-generated method stub
		jenisUsahaRepository.deleteById(id);
	}

}
