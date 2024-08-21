package com.inocomm.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.inocomm.entity.JenisUsaha;
import com.inocomm.service.impl.JenisUsahaServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/jenisusaha")
public class JenisUsahaController {

	@Autowired
	private final JenisUsahaServiceImpl jenisUsahaServiceImpl;
	
	@GetMapping(value = "/list")
	public String findJenisUsahaList(Model model) {
		model.addAttribute("jenisusaha", jenisUsahaServiceImpl.findAllJenisUsaha());
		return "be/jenisusaha/jenisusaha";
	}
	
	@GetMapping(value = "/new")
	public String loadFormAdd(Model model) {
		JenisUsaha jenisUsaha = new JenisUsaha();
		model.addAttribute("addNewJenisUsaha", jenisUsaha);
		return "be/jenisusaha/addNewJenisUsaha";
	}
	
	@PostMapping(value = "/submit")
	public String saveJenisUsaha(@ModelAttribute(value = "addNewJenisUsaha") JenisUsaha jenisUsaha){
        JenisUsaha saveJenisUsaha = jenisUsahaServiceImpl.saveJenisUsaha(jenisUsaha);
		return "redirect:/jenisusaha/list";
	}
	
	@GetMapping(value = "/form/{id}")
	public String loadFormUpdate(Model model, @PathVariable(name = "id") Long id) {
		JenisUsaha jenisUsaha = jenisUsahaServiceImpl.updateJenisUsaha(id)
				.orElseThrow(() -> new IllegalArgumentException("Gagal mendapatkan id: " + id));
		model.addAttribute("getEditSlider", jenisUsaha);
		return "be/jenisusaha/updateform";
	}
	
	@PostMapping(value = "/update/{id}")
	private String updateDataSlider(Model model, @ModelAttribute(value = "getEditSlider") JenisUsaha jenisUsaha, BindingResult result) {
		jenisUsahaServiceImpl.saveJenisUsaha(jenisUsaha);
		return "redirect:/jenisusaha/list";
	}
	
	@GetMapping(value = "/delete/{id}")
	private String deleteSlider(@PathVariable(value = "id") Long id) {
		this.jenisUsahaServiceImpl.deleteJenisUsaha(id);
		return "redirect:/jenisusaha/list";
	}
}
