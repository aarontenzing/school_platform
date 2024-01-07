package com.app.platform.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.platform.services.BerichtLinkService;
import com.app.platform.services.BerichtService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "leerlingen")
public class Leerling implements Gebruiker{
	
	@Id
	@Column(name = "leerling_id")
	private String leerling_id;
	
	@Column(name = "naam")	
	private String naam;
	
	@Column(name= "paswoord")
	private String paswoord;
	
	@Column(name= "rol")
	private String rol = "ROLE_student";
	
	@Column(name= "enabled")
	private int enabled;
	
	// foreign key van klas_id
	@ManyToOne
	@JsonManagedReference
    @JoinColumn(name = "klas_id")
    private Klas klas;
	
	@JsonBackReference
	@OneToMany(mappedBy = "leerling", fetch = FetchType.EAGER)
	private List<Score> scores;
	
	public Leerling() {
		
	}
	
	public Leerling(String id) {
		this.leerling_id = id;
	}

	@Override
	public String getId() {
		return this.leerling_id;
	}
	
	@Override
	public void setId(String id) {
		this.leerling_id = id;	
	}

	@Override
	public String getNaam() {
		return naam;
	}

	@Override
	public void setNaam(String naam) {
		this.naam = naam;
	}

	@Override
	public String getPaswoord() {
		return paswoord;
	}

	@Override
	public void setPaswoord(String paswoord) {
		this.paswoord = paswoord;
	}

	@Override
	public String getRol() {
		return rol;
	}

	@Override
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int getEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Klas getKlas() {
		return klas;
	}

	public void setKlas(Klas klas) {
		this.klas = klas;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}	
}
