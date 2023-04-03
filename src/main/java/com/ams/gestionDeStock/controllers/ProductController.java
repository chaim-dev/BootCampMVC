package com.ams.gestionDeStock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ams.gestionDeStock.repositories.ProductRepository;
@Controller
public class ProductController {
	private final ProductRepository productRepository;
	@Autowired
	
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    
    @GetMapping("listProducts")
    //@ResponseBody
    public String listProducts(Model model) {
    	
    	
        model.addAttribute("products", productRepository.findAll());
        
        return "product/listProducts.html";
         
    }
	@GetMapping("listProductsByName")
	// @ResponseBody
	public String listProductsByName(String label,Model model) {

		model.addAttribute("products", productRepository.findProductsByLabel(label));

		return "product/listProducts.html";

	}
	
}
