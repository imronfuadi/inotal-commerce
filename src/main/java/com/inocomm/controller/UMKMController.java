package com.inocomm.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inocomm.service.impl.UMKMServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/umkm")
public class UMKMController {

	@Autowired
	private final UMKMServiceImpl umkmServiceImpl;

	@GetMapping("/list")
	public String findUMKMList(Model model) {
		model.addAttribute("umkm", umkmServiceImpl.findUMKMListDetail());
		return "be/umkm/umkm";
	}

//	@PostMapping("/upload")
//	public String uploadExcelAndSaveToDatabase(@RequestParam("file") MultipartFile file, Model model) {
//	    try {
//	    	umkmServiceImpl.readExcelAndSaveToDatabase(file);
//	        model.addAttribute("message", "File berhasil diunggah dan data disimpan ke database.");
//	    } catch (IOException e) {
//	        model.addAttribute("message", "Terjadi kesalahan saat membaca file Excel.");
//	    }
//	    return "be/umkm/umkm";
//	}

	@PostMapping("/import")
	public String cretePostImport(@RequestParam(name = "file") MultipartFile file) throws Exception {

		umkmServiceImpl.importExcel(file);

		return "redirect:/umkm/list";
	}

}
