package com.app.platform.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.platform.model.Leerling;
import com.app.platform.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
	List<Score> findAllByLeerling(Leerling leering);
	
	Score saveAndFlush(Score newScore);

}
