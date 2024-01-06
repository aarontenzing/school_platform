package com.app.platform.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bericht_links")
public class BerichtLink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bericht_link_id;
	
	@ManyToOne
	@JoinColumn(name = "leerling_id")
	private Leerling ontvanger;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "bericht_id")
	private Bericht bericht;
	
	
	@Column(name= "gelezen")
	private boolean gelezen = false;

	
	public BerichtLink(Leerling ontvanger, Bericht bericht) {
		this.ontvanger = ontvanger;
		this.bericht = bericht;
	}

	public int getBericht_link_id() {
		return bericht_link_id;
	}

	public void setBericht_link_id(int bericht_link_id) {
		this.bericht_link_id = bericht_link_id;
	}

	public Leerling getOntvanger() {
		return ontvanger;
	}

	public void setOntvanger(Leerling ontvanger) {
		this.ontvanger = ontvanger;
	}

	public Bericht getBericht() {
		return bericht;
	}

	public void setBericht(Bericht bericht) {
		this.bericht = bericht;
	}


	public boolean isGelezen() {
		return gelezen;
	}

	public void setGelezen(boolean gelezen) {
		this.gelezen = gelezen;
	}
	
}
