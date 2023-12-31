package com.app.platform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Leerling;
import com.app.platform.model.Score;
import com.app.platform.model.Toets;
import com.app.platform.repos.ScoreRepository;

@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	private ScoreRepository ScoreRepo;
	
	public List<Score> findLeerling(String id) {
		Leerling obj = new Leerling(id);
		return ScoreRepo.findAllByLeerling(obj);
	}
	
	public void writeScore(int score, int afwezig, Toets toets, String leerling_id) {
		Leerling obj1 = new Leerling(leerling_id);
		Score score_leerling = new Score(score, afwezig, toets, obj1);
		ScoreRepo.saveAndFlush(score_leerling);
	}
	
	public List<Score> findAfwezigen(int bool) {
		return ScoreRepo.findAllByAfwezig(bool);
	}
	
	
	public Score findByScoreId(int id) {
		return ScoreRepo.findByScoreId(id);
	}
	

}
