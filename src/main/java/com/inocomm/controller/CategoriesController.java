package com.inocomm.controller;

import org.springframework.stereotype.Controller;

@Controller
public class CategoriesController {

	public String categoriesList() {
		return "be/categories/categories";
	}
}
