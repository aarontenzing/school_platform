package com.app.platform.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="leerkrachten")
public class Leerkracht {
	
	@Id
	@Column(name = "leerkracht_id")
	private String leerkracht_id;
	
	@Column(name = "naam")	
	private String naam;
	
	@Column(name= "paswoord")
	private String paswoord;
	
	@OneToMany(mappedBy = "leerkracht")
	private List<Toets> toetsen;
	
	// owner van relationship -> altijd mappedBy
	@ManyToMany
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

	public String getLeerkracht_id() {
		return leerkracht_id;
	}

	public void setLeerkracht_id(String leerkracht_id) {
		this.leerkracht_id = leerkracht_id;
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
	

}
