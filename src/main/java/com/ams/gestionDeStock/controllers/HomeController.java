package com.ams.gestionDeStock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ams.gestionDeStock.repositories.ProductRepository;
import com.ams.gestionDeStock.repositories.ProviderRepository;

@Controller
@RequestMapping(value = { "/", "h**" })

public class HomeController {

	private final ProviderRepository providerRepository;

	private final ProductRepository productRepository;

	@Autowired
    
	public HomeController(ProductRepository productRepository, ProviderRepository providerRepository) {
		this.productRepository = productRepository;
		this.providerRepository = providerRepository;
	}
	

	public String home() {
		return "dashboard/dashboard.html";
	}


	@RequestMapping(path = "")
	public String showStats(Model model) {

		long countProducts = productRepository.countAllProducts();
		model.addAttribute("countProducts", countProducts);
		long countProviders = providerRepository.countAllProviders();
     	model.addAttribute("countProviders", countProviders);
     	long countProductEp = productRepository.countProductsEp();
     	model.addAttribute("countProductEp", countProductEp);
		return "dashboard/dashboard.html";

	}
	

}
