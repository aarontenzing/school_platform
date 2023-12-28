package com.app.platform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gebruikers")
public class Leerling {
	
	@Id
	@Column(name = "id")
	private String rnummer;
	
	@Column(name = "naam")	
	private String naam;
	
	@Column(name= "paswoord")
	private String paswoord;
	
	@ManyToOne
    @JoinColumn(name = "klas_id")
    private Klas klas;
	
	@Column(name= "rol")
	private String rol = "ROLE_student";
	
	public Leerling() {
		
	}

}
