package com.app.platform.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "klas")
public class Klas {
	
	@Id
	private int klas_id;
	
	@Column
	private int aantal;
	
	@OneToMany(mappedBy = "klas") 
    private List<Leerling> leerlingen = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "leerkracht_id")
	private Leerkracht leerkracht;
	
	public Klas( ) {
	}

}
