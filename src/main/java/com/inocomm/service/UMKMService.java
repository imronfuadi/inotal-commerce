package com.inocomm.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inocomm.entity.UMKM;


public interface UMKMService {
	
	public List<UMKM> findUMKMListDetail();

//	public void readExcelAndSaveToDatabase(MultipartFile file) throws IOException;
	
	public void importExcel(MultipartFile file) throws Exception;
	
	
}
