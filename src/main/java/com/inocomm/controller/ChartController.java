package com.inocomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inocomm.entity.Categories;
import com.inocomm.entity.Product;
import com.inocomm.repository.CategoriesRepository;
import com.inocomm.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/chart")
public class ChartController {

//	private CategoriesRepository categoriesRepository;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/chartList")
	public String chartList(Model model) {
//		List<Categories> categories = categoriesRepository.findAll();
		List<Product> product = productServiceImpl.findProductListDetail();
		String[] labels = product.stream().map(Product::getProductName).toArray(String[]::new);
        int[] data = product.stream().mapToInt(Product::getQuantity).toArray();
        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
		return "be/chart/chart";
	}
	
	@GetMapping("/pieChart")
	public String pieChart(Model model) {
		List<Product> product = productServiceImpl.findProductListDetail();
		String[] labels = product.stream().map(Product::getProductName).toArray(String[]::new);
        int[] data = product.stream().mapToInt(Product::getQuantity).toArray();
        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
		return "be/chart/pieChart";
	}
}
