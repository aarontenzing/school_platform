package com.app.platform.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "klassen")
public class Klas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int klas_id;
	
	@JsonBackReference
	@OneToMany(mappedBy = "klas", fetch = FetchType.EAGER) 
    private List<Leerling> leerlingen = new ArrayList<>();
	
	@JsonBackReference
	@ManyToMany(mappedBy = "klassen", fetch = FetchType.EAGER)
	private List<Leerkracht> leerkrachten = new ArrayList<>();
	
	public Klas( ) {
	}
	
	public int getKlas_id() {
		return klas_id;
	}


	public void setKlas_id(int klas_id) {
		this.klas_id = klas_id;
	}


	public List<Leerling> getLeerlingen() {
		return leerlingen;
	}


	public void setLeerlingen(List<Leerling> leerlingen) {
		this.leerlingen = leerlingen;
	}


	public List<Leerkracht> getLeerkrachten() {
		return leerkrachten;
	}


	public void setLeerkrachten(List<Leerkracht> leerkrachten) {
		this.leerkrachten = leerkrachten;
	}

}
