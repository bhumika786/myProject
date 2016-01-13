package com.packt.webstore.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.repository.ProductRepository;

@Controller
public class ProductController
{
	@Autowired
	private ProductRepository productRepository;
	@RequestMapping("/products")
	public String list(Model model) {
	model.addAttribute("products", productRepository.getAllProducts());
	return "products";
	}
	
	@RequestMapping("/products/{productid}")
	public String list1(Model model,@PathVariable String productid) {
	model.addAttribute("product", productRepository.getProductById(productid));
	return "singleproduct";
	}

}

