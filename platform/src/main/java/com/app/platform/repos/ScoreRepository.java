package com.app.platform.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.platform.model.Leerling;
import com.app.platform.model.Score;
import com.app.platform.model.Toets;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
	List<Score> findAllByLeerling(Leerling leering);
	
	List<Score> findAllByAfwezig(int isAbsent);
	
	@Query("SELECT l FROM Score l WHERE l.score_id = :scoreId")
    Score findByScoreId(@Param("scoreId") int scoreId);

	List<Score> findAllByToets(Toets t);

}
