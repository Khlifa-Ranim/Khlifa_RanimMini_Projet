package com.Ranim.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.Ranim.demo.entities.Professeur;
import com.Ranim.demo.repos.ProfesseurRepository;



@Component
public class ProfesseurServiceImpl  implements ProfesseurService {

	@Autowired
	ProfesseurRepository ProfesseurRepository ;
	@Override
	public Professeur saveProfesseur(Professeur p) {
		return ProfesseurRepository.save(p);
	}
	@Override
	public Professeur updateProfesseur(Professeur p) {
	return ProfesseurRepository.save(p);
	}
	@Override
	public void deleteProfesseur(Professeur p) {
	ProfesseurRepository.delete(p);
	}
	 @Override
	public void deleteProfesseurById(Long id) {
	ProfesseurRepository.deleteById(id);
	}
	@Override
	public Professeur getProfesseur(Long id) {
	return ProfesseurRepository.findById(id).get();
	}
	@Override
	public List<Professeur> getAllProfesseurs() {
	return ProfesseurRepository.findAll();
	}
	@Override
	public Page<Professeur> getAllProfesseursParPage(int page, int size) {
		return ProfesseurRepository.findAll(PageRequest.of(page, size));

	}
}

