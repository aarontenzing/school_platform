package com.app.platform.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "leerlingen")
public class Leerling {
	
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
    @JoinColumn(name = "klas_id")
    private Klas klas;
	
	@OneToMany(mappedBy = "leerling")
	private List<Score> scores;
	
	public Leerling() {
		
	}
	
	public Leerling(String id) {
		this.leerling_id = id;
	}

	public String getLeerling_id() {
		return leerling_id;
	}

	public void setLeerling_id(String leerling_id) {
		this.leerling_id = leerling_id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getPaswoord() {
		return paswoord;
	}

	public void setPaswoord(String paswoord) {
		this.paswoord = paswoord;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getEnabled() {
		return enabled;
	}

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
