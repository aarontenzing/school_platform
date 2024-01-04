package com.app.platform.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.platform.model.Gebruiker;
import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;

public interface LeerkrachtRepository extends JpaRepository<Leerkracht, String>{
	
	// JPQL 
	@Query("SELECT l.klassen FROM Leerkracht l WHERE l.leerkracht_id = :leerkrachtId")
    List<Klas> findKlassenByLeerkrachtId(@Param("leerkrachtId") String leerkrachtId);

}
