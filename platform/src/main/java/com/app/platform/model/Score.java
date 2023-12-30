package com.app.platform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int score_id;
	
	@Column
	private int score;
	
	@Column(nullable = false)
	private int afwezig = 0;
	
	@ManyToOne
	@JoinColumn(name = "toets_id")
	private Toets toets;
	
	@ManyToOne
	@JoinColumn(name = "leerling_id")
    private Leerling leerling;
	
	public Score() {
		
	}
	
	public Score(int score, int afwezig, Toets toets, Leerling leerling) {
		this.score = score;
		this.afwezig = afwezig;
		this.toets = toets;
		this.leerling = leerling;
	}

	public int getScore_id() {
		return score_id;
	}

	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAfwezig() {
		return afwezig;
	}

	public void setAfwezig(int afwezig) {
		this.afwezig = afwezig;
	}

	public Toets getToets() {
		return toets;
	}

	public void setToets(Toets toets) {
		this.toets = toets;
	}

	public Leerling getLeerling() {
		return leerling;
	}

	public void setLeerling(Leerling leerling) {
		this.leerling = leerling;
	}

}
