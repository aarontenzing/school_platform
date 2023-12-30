package com.app.platform.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
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
	
	@OneToMany(mappedBy = "klas") 
    private List<Leerling> leerlingen = new ArrayList<>();
	
	@ManyToMany(mappedBy = "klassen")
	private List<Leerkracht> leerkracht = new ArrayList<>();
	
	
	public Klas( ) {
	}

}
