package com.app.platform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Score;
import com.app.platform.repos.ScoreRepository;

@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	private ScoreRepository ScoreRepo;
	
	public List<Score> getScoresLeerling() {
		return ScoreRepo.findAll();
	}
	
	public List<Score> getScoresStudent(String id) {
		return ScoreRepo.findAllByLeerlingId(id);
	}

}
