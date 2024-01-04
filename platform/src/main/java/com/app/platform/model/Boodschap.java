package com.app.platform.model;

import java.util.List;
import java.util.Date;
import java.util.Calendar;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.text.SimpleDateFormat;

@Entity
@Table(name="boodschappen")
public class Boodschap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boodschap_id;
	
	@ManyToOne
	@JoinColumn(name = "leerkracht_id")
	private Leerkracht zender;
	
	@ManyToOne
	@JoinColumn(name = "klas_id")
	private Klas ontvanger;

	@Column(name= "titel")
	private String titel;
	
	@Column(name= "tekst")
	private String tekst;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

	@Column(name= "publiek")
	private boolean publiek = false;
	
	
	
	public Boodschap(){
		
	}
		
	public Boodschap(Leerkracht zender, String titel, String tekst, Klas ontvanger) {
		super();
		this.zender = zender;
		this.titel = titel;
		this.tekst = tekst;
		this.ontvanger = ontvanger;
	}
	
	public Boodschap(Leerkracht zender, String titel, String tekst, boolean publiek) {
		super();
		this.zender = zender;
		this.titel = titel;
		this.tekst = tekst;
		this.publiek = publiek;
	}

	
	public Klas getOntvanger() {
		if(ontvanger == null) {
			return new Klas();
		}
		return ontvanger;
	}

	public void setOntvanger(Klas ontvanger) {
		this.ontvanger = ontvanger;
	}
	
	public Leerkracht getZender() {
		return zender;
	}

	public void setZender(Leerkracht zender) {
		this.zender = zender;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public int getBoodschap_id() {
		return boodschap_id;
	}

	public Date getCreationDateTime() {
		return this.creationDateTime;
	}
	
	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(creationDateTime);
	}
	
	public String getTimeString() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(creationDateTime);
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public void setBoodschap_id(int boodschap_id) {
		this.boodschap_id = boodschap_id;
	}
	
	public boolean isPubliek() {
		return this.publiek;
	}
	
	public void setPubliek(boolean state) {
		this.publiek = state;
	}
}
