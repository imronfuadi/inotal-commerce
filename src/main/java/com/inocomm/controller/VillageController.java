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
import com.inocomm.service.impl.VillageServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/village")
public class VillageController {

	@Autowired
	private final VillageServiceImpl villageServiceImpl;
	
	@Autowired
	private final SubdistrictServiceImpl subdistrictServiceImpl;
	
	@Autowired
	private final CityServiceImpl cityServiceImpl;
	
	@Autowired
	private final ProvinceServiceImpl provinceServiceImpl;
	
	@GetMapping("/list")
	public String findVillageList(Model model) {
		model.addAttribute("village", villageServiceImpl.findVillageList());
		System.out.println(villageServiceImpl.findVillageList());
		return "be/region/village/village";
	}
	
	@GetMapping("/new")
	public String loadVillageForm(Model model) {
		model.addAttribute("addNewVillage", new Subdistrict());
		model.addAttribute("listProvince", provinceServiceImpl.findProvinceList());
//		model.addAttribute("listCity", cityServiceImpl.findCityList());
//		System.out.println(provinceServiceImpl.findProvinceList());
//		System.out.println(cityServiceImpl.findCityList());
		return "be/region/village/addVillage";
	}
	
	@PostMapping("/submit")
	public String saveVillage(@RequestParam("name") String name, @RequestParam("province") Long province, @RequestParam("city") Long city, @RequestParam("subdistrict") Long subdistrict) {
		villageServiceImpl.saveVillage(name, province, city, subdistrict);
		return "redirect:/village/list";
	}
	@GetMapping("/api/city")
    @ResponseBody
    public List<City> getCityByProvince(@RequestParam Long provinceId) {
        return cityServiceImpl.getCityByProvince(provinceId);
    }
	
	@GetMapping("/api/subdistrict")
    @ResponseBody
    public List<Subdistrict> getSubdistrictByCity(@RequestParam Long cityId) {
        return subdistrictServiceImpl.getSubdistrictByCity(cityId);
    }
}
