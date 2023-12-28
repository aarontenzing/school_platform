package com.app.platform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gebruikers")
public class Leerkracht {
	
	@Id
	@Column(name = "id")
	private String dnummer;
	
	@Column(name = "naam")	
	private String naam;
	
	@Column(name= "paswoord")
	private String paswoord;
	
	@Column(name= "rol")
	private String rol = "ROLE_docent";
	
	public Leerkracht() {
		
	}

}
