package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Leerling;
import com.app.platform.model.Score;
import com.app.platform.model.Toets;

public interface IScoreService {
	public List<Score> findAllByLeerling(Leerling leerling);
	
	public void writeScore(int score, int afwezig, Toets toets, Leerling leerling);
	
	public List<Score> findAfwezigen(int bool);
	
	public Score findByScoreId(int id);
	
	public void updateScore(Score score);

	public List<Score> findAllByToets(Toets t) ;

	public Score getById(int id);

	public void save(Score t);
}
