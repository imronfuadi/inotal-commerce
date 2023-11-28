package com.inocomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inocomm.entity.City;
import com.inocomm.service.impl.CityServiceImpl;
import com.inocomm.service.impl.ProvinceServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

	@Autowired
	private final CityServiceImpl cityServiceImpl;
	
	@Autowired
	private final ProvinceServiceImpl provinceServiceImpl;
	
	@GetMapping("/list")
	public String findCityist(Model model) {
		model.addAttribute("city", cityServiceImpl.findCityList());
		System.out.println(cityServiceImpl.findCityList());
		return "be/region/city/city";
	}
	
	@GetMapping("/new")
	public String loadCityForm(Model model) {
		model.addAttribute("addNewCity", new City());
		model.addAttribute("listProvince", provinceServiceImpl.findProvinceList());
		System.out.println(provinceServiceImpl.findProvinceList());
		return "be/region/city/addCity";
	}
	
	@PostMapping("/submit")
	public String saveCity(@RequestParam("name") String name, @RequestParam("province") Long province) {
		cityServiceImpl.saveCity(name, province);
		return "redirect:/city/list";
	}
}
