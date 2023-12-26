package com.app.platform.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Leerkrachten")
public class Leerkracht {
	
	@Id
	@Column(name = "id")
	private String dnummer;
	
	@Column(name = "naam")	
	private String naam;
	
	@OneToMany
	@JoinColumn(name = "klas")	
	private ArrayList<Klas> klassen = new ArrayList<Klas>();
	
	@OneToMany
	@JoinColumn(name = "toets")	
	private ArrayList<Toets> toetsen = new ArrayList<Toets>();
	
	public Leerkracht() {
	}
	
	public Leerkracht(String dnummer, String naam) {
		this.dnummer = dnummer;
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public ArrayList<Klas> getKlassen() {
		return klassen;
	}

	public void setKlassen(ArrayList<Klas> klassen) {
		this.klassen = klassen;
	}

	public ArrayList<Toets> getToetsen() {
		return toetsen;
	}

	public void setToetsen(ArrayList<Toets> toetsen) {
		this.toetsen = toetsen;
	}

}
