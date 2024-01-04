package com.app.platform.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="boodschappen_links")
public class BoodschapLink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boodschap_link_id;
	
	@ManyToOne
	@JoinColumn(name = "leerling_id")
	private Leerling ontvanger;
	
	@ManyToOne
	@JoinColumn(name = "boodschap_id")
	private Boodschap boodschap;
	
	
	@Column(name= "gelezen")
	private boolean gelezen = false;

	public BoodschapLink(){
		
	}
	
	public BoodschapLink(Leerling ontvanger, Boodschap boodschap) {
		super();
		this.ontvanger = ontvanger;
		this.boodschap = boodschap;
	}

	public int getBoodschap_link_id() {
		return boodschap_link_id;
	}

	public void setBoodschap_link_id(int boodschap_link_id) {
		this.boodschap_link_id = boodschap_link_id;
	}

	public Leerling getOntvanger() {
		return ontvanger;
	}

	public void setOntvanger(Leerling ontvanger) {
		this.ontvanger = ontvanger;
	}

	public Boodschap getBoodschap() {
		return boodschap;
	}

	public void setBoodschap(Boodschap boodschap) {
		this.boodschap = boodschap;
	}


	public boolean isGelezen() {
		return gelezen;
	}

	public void setGelezen(boolean gelezen) {
		this.gelezen = gelezen;
	}
	
}
