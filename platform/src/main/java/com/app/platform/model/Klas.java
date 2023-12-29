package com.app.platform.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "leerkracht_id")
	private Leerkracht leerkracht;
	
	
	public Klas( ) {
	}

}
