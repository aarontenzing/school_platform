package com.app.platform.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.platform.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
}
