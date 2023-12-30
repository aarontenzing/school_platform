package com.app.platform.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;


public interface KlasRepository extends JpaRepository<Klas, Integer>{

	// JPQL -> 
	@Query("SELECT l.leerlingen FROM Klas l WHERE l.klas_id = :klasId")
	List<Leerling> findLeerlingenByKlas(@Param("klasId") String klasId);
}
