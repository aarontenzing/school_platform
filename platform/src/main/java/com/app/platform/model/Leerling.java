package com.app.platform.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "leerlingen")
public class Leerling {
	
	@Id
	@Column(name = "leerling_id")
	private String leerling_id;
	
	@Column(name = "naam")	
	private String naam;
	
	@Column(name= "paswoord")
	private String paswoord;
	
	@Column(name= "rol")
	private String rol = "ROLE_student";
	
	@Column(name= "enabled")
	private int enabled;
	
	@ManyToOne
    @JoinColumn(name = "klas_id")
    private Klas klas;
	
	@OneToMany(mappedBy = "leerling")
	private List<Score> scores;
	
	public Leerling() {
		
	}

}
