package com.inocomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inocomm.entity.City;
import com.inocomm.entity.Subdistrict;
import com.inocomm.service.impl.CityServiceImpl;
import com.inocomm.service.impl.ProvinceServiceImpl;
import com.inocomm.service.impl.SubdistrictServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/subdistrict")
public class SubdistrictController {

	@Autowired
	private final CityServiceImpl cityServiceImpl;
	
	@Autowired
	private final ProvinceServiceImpl provinceServiceImpl;
	
	@Autowired
	private final SubdistrictServiceImpl subdistrictServiceImpl;
	
	@GetMapping("/list")
	public String findSubdistrictList(Model model) {
		model.addAttribute("subdistrict", subdistrictServiceImpl.findSubdistricList());
		System.out.println(subdistrictServiceImpl.findSubdistricList());
		return "be/region/subdistrict/subdistrict";
	}
	
	@GetMapping("/new")
	public String loadSubdistrictForm(Model model) {
		model.addAttribute("addNewSubdistrict", new Subdistrict());
		model.addAttribute("listProvince", provinceServiceImpl.findProvinceList());
//		model.addAttribute("listCity", cityServiceImpl.findCityList());
//		System.out.println(provinceServiceImpl.findProvinceList());
//		System.out.println(cityServiceImpl.findCityList());
		return "be/region/subdistrict/addSubdistrict";
	}
	
	@PostMapping("/submit")
	public String saveSubdistrict(@RequestParam("name") String name, @RequestParam("province") Long province, @RequestParam("city") Long city) {
		subdistrictServiceImpl.saveSubdistrict(name, province, city);
		return "redirect:/subdistrict/list";
	}
	
	@GetMapping("/api/city")
    @ResponseBody
    public List<City> getCityByProvince(@RequestParam Long provinceId) {
        return cityServiceImpl.getCityByProvince(provinceId);
    }
}
