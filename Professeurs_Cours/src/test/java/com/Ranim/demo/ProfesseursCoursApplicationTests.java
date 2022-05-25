package com.Ranim.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Ranim.demo.entities.Cours;
import com.Ranim.demo.entities.Professeur;
import com.Ranim.demo.repos.ProfesseurRepository;
import com.Ranim.demo.Service.ProfesseurService;

@SpringBootTest
class ProfesseursCoursApplicationTests {

	@Autowired
	private ProfesseurRepository ProfesseurRepository;
	
	@Autowired
	private ProfesseurService  ProfesseurService;
	
	
	@Test
	public void testCreateProfesseur() {
	Professeur prod = new Professeur("KHLIFA","Ranim",14650181,"Khlifaranim@gmail.com",new Date());
	ProfesseurRepository.save(prod);
	}

	/*@Test
	public void testFindProfesseur()
	{
	Professeur p = ProfesseurRepository.findById(1L).get(); 
	System.out.println(p);
	}*/

	@Test
	public void testUpdateProfesseur()
	{
	Professeur p = ProfesseurRepository.findById(2L).get();
	p.setCIN(14650183);
	ProfesseurRepository.save(p);
	
	System.out.println(p);
	}
    
	@Test
	public void testDeleteProfesseur()
	{
	ProfesseurRepository.deleteById(5L);
	}
	
	
	@Test
	public void testListerTousProfesseurs()
	{
	List<Professeur> profs = ProfesseurRepository.findAll();
	for (Professeur p : profs)
	{
	System.out.println(p);
	}
	}
	
	/*@Test
	public void testFindByNomProfesseurContains()
	{
	Page<Professeur> profs = ProfesseurService.getAllProfesseursParPage(0,2);
	System.out.println(profs.getSize());
	System.out.println(profs.getTotalElements());
	System.out.println(profs.getTotalPages());
	profs.getContent().forEach(p -> {System.out.println(p.toString());
	 });	
	
	
	/*ou bien
	for (Professeur p : profs)
	{
	System.out.println(p);
	} 
	}*/
    
	 @Test
	 public void testFindByNomProfesseur()
	 {
	 List<Professeur> profs = ProfesseurRepository.findByNomProf("Khlifa");
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testFindByNomProfesseurContains ()
	 {
	 List<Professeur> profs=ProfesseurRepository.findByNomProfContains("Khlifa");
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 } }
    
	 
	 @Test
	 public void testfindByCIN()
	 {
	 List<Professeur> profs = ProfesseurRepository.findByCIN("KHLIFA", 14650181);
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testfindByCours()
	 {
	 Cours cours = new Cours();
	 cours.setIdCours(1L);
	 List<Professeur> profs = ProfesseurRepository.findByCours(cours);
	 for (Professeur p : profs)
	 {
	 System.out.println(p);
	 }
	 
	 }
	

	
}
