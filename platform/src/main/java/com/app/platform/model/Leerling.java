package com.app.platform.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leerlingen")
public class Leerling {
	
	@Id
	@Column(name = "id")
	private String rnummer;
	
	@Column(name = "naam")	
	private String naam;
	
	@ManyToOne
	@JoinColumn(name = "klas_id")	
	private Klas klas;
	
	@OneToMany(mappedBy = "Leerlingen", cascade = CascadeType.ALL)
    @MapKey(name = "Toets")
	private ArrayList<Toets> toetsen = new ArrayList<Toets>();
	
	public Leerling() {
	}
	
	public Leerling(String rnummer, String naam, Klas klas) {
		this.rnummer = rnummer;
		this.naam = naam;
		this.klas = klas;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Klas getKlas() {
		return klas;
	}

	public void setKlas(Klas klas) {
		this.klas = klas;
	}

	public ArrayList<Toets> getToetsen() {
		return toetsen;
	}

	public void setToetsen(ArrayList<Toets> toetsen) {
		this.toetsen = toetsen;
	}

}
