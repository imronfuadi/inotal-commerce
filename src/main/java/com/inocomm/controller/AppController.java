package com.inocomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inocomm.service.impl.ProductServiceImpl;
import com.inocomm.service.impl.SliderServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AppController {
	
	@Autowired
	private final ProductServiceImpl productServiceImpl;
	
	@Autowired
	private final SliderServiceImpl sliderServiceImpl;

	@GetMapping(value = "")
    public String getIndex(){
        return "be/index";
    }
	
	@GetMapping(value = "/dashboardFe")
	public String getDashboardFe(Model model) {
		model.addAttribute("products", productServiceImpl.findProductListDetail());
		model.addAttribute("slider", sliderServiceImpl.findAllSlider());
		return "fe/dashboardFe";
	}
}
