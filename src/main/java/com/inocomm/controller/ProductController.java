package com.inocomm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.inocomm.dto.ProductCreateRequestDTO;
import com.inocomm.dto.ProductListResponseDTO;
import com.inocomm.dto.ProductUpdateRequestDTO;
import com.inocomm.entity.Product;
import com.inocomm.service.ProductService;
import com.inocomm.service.impl.ProductServiceImpl;
import com.inocomm.util.FileUploadUtil;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	// TANPA DTO
	@Autowired
	private final ProductServiceImpl productServiceImpl;

	@GetMapping("/list")
	public String findProductList(Model model) {
		model.addAttribute("products", productServiceImpl.findProductListDetail());
		return "be/product/products";
	}

	@GetMapping(value = "/new")
	public String loadProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("addNewProduct", product);
		return "be/product/addNewProduct";
	}

	@PostMapping(value = "/submit")
	public String saveData(@ModelAttribute(value = "product") Product product,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		product.setPict(fileName);
		Product saveProduct = productServiceImpl.saveProduct(product);
		String uploadDir = "src/main/resources/static/assets/images/product/";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return "redirect:/product/list";
	}

	@GetMapping("/form/{id}")
	public String loadProductFormUpdate(Model model, @PathVariable(name = "id") Long id) {
		Product product = productServiceImpl.updateProduct(id)
				.orElseThrow(() -> new IllegalArgumentException("Gagal mendapatkan id: " + id));
		model.addAttribute("getEditProduct", product);
		return "/be/product/editProduct";
	}

	@PostMapping(value = "/update/{id}")
	public String updateData(Model model, @ModelAttribute(value = "product") Product product,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		product.setPict(fileName);
		Product saveProduct = productServiceImpl.saveProduct(product);
		String uploadDir = "src/main/resources/static/assets/images/product/";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//		productServiceImpl.saveProduct(product);
		return "redirect:/product/list";
	}

	// METHOD UNTUK MENGHAPUS DATA
	@GetMapping(value = "/delete/{id}")
	public String deleteData(@PathVariable(value = "id") Long id) {
		this.productServiceImpl.deleteProduct(id);
		return "redirect:/product/list";
	}

	@GetMapping(value = "/productDetail/{id}")
	public String findProductListDetail(Model model, @PathVariable(name = "id") Long id) {
		Product product1 = productServiceImpl.findProductByid(id)
				.orElseThrow(() -> new IllegalArgumentException("Gagal mendapatkan id: " + id));
		model.addAttribute("productDetail", product1);
		return "/fe/productDetail";
	}

	// Dengan DTO
//	private final ProductService productService;
//
//	@GetMapping("/list")
//	public String findProductList(Model model) {
//		List<ProductListResponseDTO> products = productService.findProductListDetail();
//		model.addAttribute("products", products);
//		return "be/product/products";
//	}
//	
//	@GetMapping("/new")
//	public String loadCreateProductForm(Model model) {
//		ProductCreateRequestDTO dto = new ProductCreateRequestDTO();
//		model.addAttribute("bookCreateDTO", dto);
//		return "be/product/addNewProduct";
//	}
//
//	@PostMapping("/submit")
//	public String addNewBook(@ModelAttribute("bookCreateDTO") @Valid ProductCreateRequestDTO dto, 
//			BindingResult bindingResult,
//			Errors errors,
//			Model model) {
//		if(errors.hasErrors()) {
//			model.addAttribute("bookCreateDTO", dto);
//			return "be/product/addNewProduct";
//		}
//		productService.createNewProduct(dto);
//		return "redirect:/product/list";
//	}
//	
//	@GetMapping("/formEdit/{id}")
//	public String loadEditProductForm(Model model) {
//		ProductUpdateRequestDTO dto = new ProductUpdateRequestDTO();
//		model.addAttribute("bookEditDTO", dto);
//		return "be/product/editProduct";
//	}
//	
////	public String updateDataproduct(Model model, ProductUpdateRequestDTO dto) {
////		
////	}
//	
//	@GetMapping("/delete/{id}")
//	public String deleteProduct(Long ProductId) {
//		productService.deleteProduct(ProductId);
//		return "redirect:/product/list";
//	}
}
