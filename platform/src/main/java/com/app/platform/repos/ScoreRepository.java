package com.app.platform.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.platform.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
	List<Score> findAll();
	
	@Query("SELECT s FROM Score s WHERE s.leerling.leerling_id = :leerlingId")
    List<Score> findAllByLeerlingId(@Param("leerlingId") String leerlingId);

}
