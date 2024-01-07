package com.app.platform.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.text.SimpleDateFormat;

@Entity
@Table(name="berichten")
public class Bericht {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bericht_id;
	
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
	

	public Bericht(){
		
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

	public int getBericht_id() {
		return bericht_id;
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

	public void setBericht_id(int bericht_id) {
		this.bericht_id = bericht_id;
	}
	
	public boolean isPubliek() {
		return this.publiek;
	}
	
	public void setPubliek(boolean state) {
		this.publiek = state;
	}
}
