package com.app.platform.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "toetsen")
public class Toets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int toets_id;
	
	@Column
	private String toets_naam;
	
	@JsonBackReference
	@OneToMany(mappedBy = "toets", fetch = FetchType.EAGER)
	private List<Score> scores;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "leerkracht_id")
	private Leerkracht leerkracht;
	
	public Toets() {
	}
	
	public Toets(int toets_id) {
		this.toets_id = toets_id;
	}
	
	public Toets(String naam, Leerkracht leerkracht) {
		this.toets_naam = naam;
		this.leerkracht = leerkracht;
	}

	public int getToets_id() {
		return toets_id;
	}

	public void setToets_id(int toets_id) {
		this.toets_id = toets_id;
	}

	public String getToets_naam() {
		return toets_naam;
	}

	public void setToets_naam(String toets_naam) {
		this.toets_naam = toets_naam;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Leerkracht getLeerkracht() {
		return leerkracht;
	}

	public void setLeerkracht(Leerkracht leerkracht) {
		this.leerkracht = leerkracht;
	}

}
