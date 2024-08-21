package com.inocomm.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inocomm.entity.UMKM;
import com.inocomm.repository.UMKMRepository;
import com.inocomm.service.UMKMService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UMKMServiceImpl implements UMKMService {

	@Autowired
	private final UMKMRepository umkmRepository;

//	@Override
//	public void readExcelAndSaveToDatabase(MultipartFile file) throws IOException {
//		Workbook workbook = WorkbookFactory.create(file.getInputStream());
//		Sheet sheet = workbook.getSheetAt(0);
//
//		for (Row row : sheet) {
//			String merk = row.getCell(1).getStringCellValue();
//			String pemilik = row.getCell(2).getStringCellValue();
//			String nik = row.getCell(3).getStringCellValue();
//			String alamat = row.getCell(4).getStringCellValue();
//
//			UMKM umkm = new UMKM();
//			umkm.setMerk(merk);
//			umkm.setPemilik(pemilik);
//			umkm.setNik(nik);
//			umkm.setAlamat(alamat);
//
//			umkmRepository.save(umkm);
//		}
//
//		workbook.close();
//	}

	@Override
	public List<UMKM> findUMKMListDetail() {
		return umkmRepository.findAll();
	}

	@Override
	public void importExcel(MultipartFile file) throws Exception {
		Workbook workbook = new XSSFWorkbook(file.getInputStream());
		Sheet sheet = workbook.getSheetAt(0);

		for (int i = 0; i < (CoutRowExcel(sheet.rowIterator())); i++) {
			if (i == 0) {
				continue;
			}

			Row row = sheet.getRow(i);

			UMKM umkm = new UMKM();
			
			String merk = row.getCell(1).getStringCellValue();
			String pemilik = row.getCell(2).getStringCellValue();
//			String nik = row.getCell(3).getStringCellValue();
			String alamat = row.getCell(4).getStringCellValue();
			
//			Cell cell = row.getCell(3); // Misalkan indeks kolomnya adalah 3 (indeks dimulai dari 0)
//
//			if (cell != null) {
//			    if (cell.getCellType() == CellType.NUMERIC) {
//			        // Jika sel adalah tipe numerik
//			        String nik = NumberToTextConverter.toText(cell.getNumericCellValue());
//			        // Gunakan nilai nik sesuai kebutuhan Anda
//			    } else if (cell.getCellType() == CellType.STRING) {
//			        // Jika sel adalah tipe string
//			        String nik = cell.getStringCellValue();
//			        // Gunakan nilai nik sesuai kebutuhan Anda
//			    } else {
//			        // Tipe sel lainnya (misalnya formula, blank, dll.), Handle sesuai kebutuhan Anda
//			    }
//			} else {
//			    // Handle jika sel kosong
//			    String nik = ""; // Atau nilai default lainnya sesuai kebutuhan Anda
//			    // Gunakan nilai nik sesuai kebutuhan Anda atau lakukan tindakan yang sesuai dengan aplikasi Anda
//			}
			
			Cell cell = row.getCell(3); // Misalkan kolom pertama (indeks dimulai dari 0)

			if (cell != null && cell.getCellType() == CellType.NUMERIC) {
			    // Jika sel tidak kosong dan berisi nilai numerik
			    String nik = NumberToTextConverter.toText(cell.getNumericCellValue());
			    System.out.println("Nilai dalam bentuk string: " + nik);
			    umkm.setNik(nik);
			} else {
			    // Handle jika sel kosong atau bukan tipe numerik
			    System.out.println("Sel kosong atau bukan tipe numerik.");
			}

			
			umkm.setMerk(merk);
			umkm.setPemilik(pemilik);
			umkm.setAlamat(alamat);

			umkmRepository.save(umkm);
		}

	}

	public static int CoutRowExcel(Iterator<Row> iterator) {
		int size = 0;
		while (iterator.hasNext()) {
			Row row = iterator.next();
			size++;
		}
		return size;
	}


}
