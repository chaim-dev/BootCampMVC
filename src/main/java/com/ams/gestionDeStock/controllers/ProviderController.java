package com.ams.gestionDeStock.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ams.gestionDeStock.entities.Provider;
import com.ams.gestionDeStock.repositories.ProviderRepository;

@Controller
public class ProviderController {
	private final ProviderRepository providerRepository;

	@Autowired
	public ProviderController(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	@GetMapping("listProviders")
	// @ResponseBody
	public String listProviders(Model model) {

		model.addAttribute("providers", providerRepository.findAll());

		return "providers/listProviders.html";

	}

	// redirection
	@GetMapping("dashboard")
	// @ResponseBody
	public String redirectToDashboard() {

		return "redirect:home";

	}

	@GetMapping("listProvidersByName")
	// @ResponseBody
	public String listProvidersByName(String name,Model model) {

		model.addAttribute("providers", providerRepository.findProductsByName(name));

		return "fragments/headerBack.html";

	}
	
    @GetMapping("addProvider")
    public String showAddProviderForm(Model model) {
    	Provider provider = new Provider();// object dont la valeur des attributs par defaut
    	model.addAttribute("provider", provider);
        return "providers/addProvider";
    }
    
    @PostMapping("addProvider")
    public String addProvider(@Valid Provider provider, BindingResult result) {
        if (result.hasErrors()) {
            return "providers/addProvider";
        }
        if(provider.getName()=="")
        	provider.setName(null);
        //providerRepository.save(provider);
        providerRepository.save(provider);
        System.out.println("The answer to everything is " + provider);
     
        return "redirect:listProviders";
    }
}
