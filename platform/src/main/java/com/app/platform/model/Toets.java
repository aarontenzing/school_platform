package com.app.platform.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@OneToMany
	@JoinColumn(name = "score_id")
	private List<Score> scores;
	
	@ManyToOne
	@JoinColumn(name = "leerkracht_id")
	private Leerkracht leerkracht;
	
	public Toets() {
		
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
