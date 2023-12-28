package com.app.platform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "toetsen")
public class Toets {

	@Id
	@Column
	private int toets_id;
	
	@Column
	private String toets_naam;
	
	@ManyToOne
	@JoinColumn(name = "dnummer")
	private Leerkracht docent;
	
	public Toets() {
		
	}

}