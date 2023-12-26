package com.app.platform.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Klas")
public class Klas {
	
	@Id
	@Column(name = "klas_id")
	private int id;
	
	@Column(name = "aantal")
	private int aantal;
	
	@OneToMany(mappedBy = "Klas", cascade = CascadeType.ALL)
	private ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public ArrayList<Leerling> getLeerlingen() {
		return leerlingen;
	}

	public void setLeerlingen(ArrayList<Leerling> leerlingen) {
		this.leerlingen = leerlingen;
	}
	
	
	

}
