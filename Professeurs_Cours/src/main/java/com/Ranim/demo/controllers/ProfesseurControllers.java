package com.Ranim.demo.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ranim.demo.entities.Professeur;
import com.Ranim.demo.Service.ProfesseurService;



@Controller
public class ProfesseurControllers {

	@Autowired
	ProfesseurService ProfesseurService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{

   modelMap.addAttribute("Professeur", new Professeur());
	return "createProfesseur";
	}
	
	@RequestMapping("/saveProfesseur")
	public String saveProfesseur(@Valid Professeur Professeur, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "createProfesseur";
	 ProfesseurService.saveProfesseur(Professeur);
	return "createProfesseur";
	}
	
	
	@RequestMapping("/ListeProfesseurs")
	public String listeProfesseurs(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)

	{
		Page<Professeur> prods = ProfesseurService.getAllProfesseursParPage(page, size);
		modelMap.addAttribute("Professeurs", prods);
		 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeProfesseurs";

	}
	
	@RequestMapping("/supprimerProfesseur")
	public String supprimerProfesseur(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)

	
	
	{ 
		ProfesseurService.deleteProfesseurById(id);
		Page<Professeur> prods = ProfesseurService.getAllProfesseursParPage(page, 
		size);
		modelMap.addAttribute("Professeurs", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeProfesseurs";

	}
	
	@RequestMapping("/modifierProfesseur")
	public String editerProfesseur(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Professeur p= ProfesseurService.getProfesseur(id);
	modelMap.addAttribute("Professeur", p);
	return "editerProfesseur";
	}
	@RequestMapping("/updateProfesseur")
	public String updateProfesseur(@ModelAttribute("Professeur") Professeur Professeur,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 Professeur.setDateCreation(dateCreation);
		 
		 ProfesseurService.updateProfesseur(Professeur);
		 List<Professeur> prods = ProfesseurService.getAllProfesseurs();
		 modelMap.addAttribute("Professeurs", prods);
		return "listeProfesseurs";
		}



	
	
}
