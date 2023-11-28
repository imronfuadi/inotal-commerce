package com.inocomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inocomm.entity.Province;
import com.inocomm.service.impl.ProvinceServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	private final ProvinceServiceImpl provinceServiceImpl;
	
	@GetMapping("/list")
	public String findProvinceList(Model model) {
		model.addAttribute("province", provinceServiceImpl.findProvinceList());
		return "be/region/province/province";
	}
	
	@GetMapping("/new")
	public String loadProvinceForm(Model model) {
		Province province = new Province();
		model.addAttribute("addNewProvince", province);
		return "be/region/province/addProvince";
	}
	
	@PostMapping("/submit")
	public String saveProvince(Province province) {
		provinceServiceImpl.saveProvince(province);
		return "redirect:/province/list";
	}
}
