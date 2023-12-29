package com.app.platform.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "klassen")
public class Klas {
	
	@Id
	private int klas_id;
	
	@OneToMany(mappedBy = "klas") 
    private List<Leerling> leerlingen = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "leerkracht_id")
	private Leerkracht leerkracht;
	
	// bidirectionele relatie
	@ManyToMany
	@JoinTable(
			name = "klas_leerkrachten",
			joinColumns = @JoinColumn(name = "klas_id"),
			inverseJoinColumns = @JoinColumn(name = "leerkracht_id")
	)
    private List<Leerkracht> leerkrachten;
	
	public Klas( ) {
	}

}
