package com.codingdojo.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.models.Ninja;
import com.codingdojo.dojosAndNinjas.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	
	@GetMapping("/")
	public String addDojoForm(@ModelAttribute("dojo")Dojo dojo, Model model) {
		List<Dojo> dojos = mainService.allDojo();
		model.addAttribute("dojos", dojos);
		return "new_dojo.jsp";
	}
	
	@PostMapping("/dojo/add")
	public String addDojoProcess(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "new_dojo.jsp";
		} else {
			mainService.saveDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = mainService.oneDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
	
	@GetMapping("/ninja/add")
	public String addNinjaForm(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = mainService.allDojo();
		model.addAttribute("dojos", dojos);
		return "new_ninja.jsp";
	}
	
	@PostMapping("/ninja/add")
	public String addNinjaProcess(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = mainService.allDojo();
			model.addAttribute("dojos", dojos);
			return "new_ninja.jsp";
		} else {
			mainService.saveNinja(ninja);
			return "redirect:/";
		}
	}
}
