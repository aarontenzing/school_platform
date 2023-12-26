package com.app.platform.model;

import java.util.Dictionary;
import java.util.Hashtable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Toetsen")
public class Toets {
	
	@Id
	@Column(name = "toets_id")
	private int id;
	
	@Column(name = "vak")
	private String vak;
	
	@ManyToOne
    @JoinColumn(name = "klas_id")
	private Klas klas;
	
	@OneToMany(mappedBy = "Toets", cascade = CascadeType.ALL)
	private Dictionary<Leerling, Integer> leerlingen_dictonaries = new Hashtable<>();
	
	public Toets() {
	}
	
	public Toets(int id, String vak, int Score) {
	}

	public String getVak() {
		return vak;
	}

	public void setVak(String vak) {
		this.vak = vak;
	}

	public Dictionary<Leerling, Integer> getLeerlingen_dictonaries() {
		return leerlingen_dictonaries;
	}

	public void setLeerlingen_dictonaries(Dictionary<Leerling, Integer> leerlingen_dictonaries) {
		this.leerlingen_dictonaries = leerlingen_dictonaries;
	}

}
