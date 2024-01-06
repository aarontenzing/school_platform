package com.app.platform.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="leerkrachten")
public class Leerkracht implements Gebruiker{
	
	@Id
	@Column(name = "leerkracht_id")
	private String leerkracht_id;
	
	@Column(name = "naam")	
	private String naam;
	
	@Column(name= "paswoord")
	private String paswoord;
	
	@JsonBackReference
	@OneToMany(mappedBy = "leerkracht", fetch = FetchType.EAGER)
	private List<Toets> toetsen;
	
	// owner van relationship -> altijd mappedBy
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonManagedReference
	@JoinTable(name = "leerkracht_klas", 
		joinColumns = @JoinColumn(name = "leerkracht_id"),
		inverseJoinColumns = @JoinColumn(name = "klas_id")
	)
	private List<Klas> klassen;

	@Column(name= "rol")
	private String rol = "ROLE_docent";
	
	@Column(name= "enabled")
	private int enabled;
	
	public Leerkracht() {
	}
	
	public Leerkracht(String leerkracht_id) {
		this.leerkracht_id = leerkracht_id;
	}

	@Override
	public String getId() {
		return this.leerkracht_id;
	}

	@Override
	public void setId(String id) {
		this.leerkracht_id = id;
		
	}

	@Override
	public String getNaam() {
		return this.naam;
	}

	@Override
	public void setNaam(String naam) {
		this.naam = naam;
	}

	@Override
	public String getPaswoord() {
		return this.paswoord;
	}

	@Override
	public void setPaswoord(String paswoord) {
		this.paswoord = paswoord;	
	}

	@Override
	public String getRol() {
		return this.rol;
	}

	@Override
	public void setRol(String rol) {
		this.rol = rol;		
	}

	@Override
	public int getEnabled() {
		return this.enabled;
	}

	@Override
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<Toets> getToetsen() {
		return toetsen;
	}

	public void setToetsen(List<Toets> toetsen) {
		this.toetsen = toetsen;
	}

	public List<Klas> getKlassen() {
		return klassen;
	}

	public void setKlassen(List<Klas> klassen) {
		this.klassen = klassen;
	}	

}
