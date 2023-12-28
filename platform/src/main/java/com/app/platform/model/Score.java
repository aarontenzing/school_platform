package com.app.platform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {
	
	@Id
	@Column
	private int score_id;
	
	@Column
	private int score;
	
	@ManyToOne
	@JoinColumn(name = "toets_id")
	private Toets toets;
	
	@ManyToOne
    @JoinColumn(name = "leerling_id")
    private Leerling leerling;
	
	public Score() {
		
	}

}
