package com.app.platform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Leerling;
import com.app.platform.model.Score;
import com.app.platform.model.Toets;
import com.app.platform.repos.ScoreRepository;

@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	private ScoreRepository scoreRepo;
	
	public List<Score> findAllByLeerling(Leerling leerling) {
		return scoreRepo.findAllByLeerling(leerling);
	}
	
	public void writeScore(int score, int afwezig, Toets toets, Leerling leerling) {
		Score score_leerling = new Score(score, afwezig, toets, leerling);
		scoreRepo.save(score_leerling);
	}
	
	public List<Score> findAfwezigen(int bool) {
		return scoreRepo.findAllByAfwezig(bool);
	}
	
	
	public Score findByScoreId(int id) {
		return scoreRepo.findByScoreId(id);
	}
	
	public void updateScore(Score score) {
		scoreRepo.save(score);
	}

	public List<Score> findAllByToets(Toets t) {
		return scoreRepo.findAllByToets(t);
	}

	public Score getById(int id) {
		Optional<Score> s = scoreRepo.findById(id);
		if(s.isPresent()) {
			return s.get();
		}
		return null;
	}

	public void save(Score t) {
		scoreRepo.save(t);		
	}
	

}
