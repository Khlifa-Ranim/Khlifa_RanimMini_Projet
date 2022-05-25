package com.Ranim.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cours {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCours;
	private String nomCours;
	private String descriptionCours;
	
	@OneToMany(mappedBy = "Cours")
	private List<Professeur> Professeurs;

	

	public Cours(String nomCours, String descriptionCours, List<Professeur> professeurs) {
		super();
		this.nomCours = nomCours;
		this.descriptionCours = descriptionCours;
		Professeurs = professeurs;
	}

	public Long getIdCours() {
		return idCours;
	}

	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}

	public String getDescriptionCours() {
		return descriptionCours;
	}

	public void setDescriptionCours(String descriptionCours) {
		this.descriptionCours = descriptionCours;
	}

	public List<Professeur> getProfesseurs() {
		return Professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		Professeurs = professeurs;
	}

	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", nomCours=" + nomCours + ", descriptionCours=" + descriptionCours
				+ ", Professeurs=" + Professeurs + "]";
	}

	

}
 