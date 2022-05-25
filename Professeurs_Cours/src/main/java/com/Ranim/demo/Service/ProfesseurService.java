package com.Ranim.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Ranim.demo.entities.Professeur;

public interface ProfesseurService {
	Professeur saveProfesseur(Professeur p);
	
	Professeur updateProfesseur(Professeur p);
	
	void deleteProfesseur(Professeur p);
	
	 void deleteProfesseurById(Long id);
	 
	Professeur getProfesseur(Long id);
	
	List<Professeur> getAllProfesseurs();
	
	Page<Professeur> getAllProfesseursParPage(int page, int size);
	


}

