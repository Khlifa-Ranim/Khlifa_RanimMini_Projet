package com.Ranim.demo.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
public class Professeur {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProf;
	
	@NotNull
	@Size (min = 4,max = 15)
    private String nomProf;
	
	@NotNull
	@Size (min = 4,max = 15)
    private String prenomProf;
    private int CIN;
    private String adresse;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation;
    
    
    @ManyToOne
    private Cours Cours;
    
    
  
    
	public Cours getCours() {
		return Cours;
	}

	public void setCours(Cours cours) {
		Cours = cours;
	}

	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professeur(String nomProf, String prenomProf, int cIN, String adresse, Date dateCreation) {
		super();
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		CIN = cIN;
		this.adresse = adresse;
		this.dateCreation = dateCreation;
	}

	public long getIdProf() {
		return idProf;
	}

	public void setIdProf(long idProf) {
		this.idProf = idProf;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public String getPrenomProf() {
		return prenomProf;
	}

	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	public int getCIN() {
		return CIN;
	}

	public void setCIN(int cIN) {
		CIN = cIN;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Professeur [idProf=" + idProf + ", nomProf=" + nomProf + ", prenomProf=" + prenomProf + ", CIN=" + CIN
				+ ", adresse=" + adresse + ", dateCreation=" + dateCreation + "]";
	}
    



	
	

	
	

}
