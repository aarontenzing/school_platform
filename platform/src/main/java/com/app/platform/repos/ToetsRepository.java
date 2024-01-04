package com.app.platform.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.platform.model.Toets;


public interface ToetsRepository extends JpaRepository<Toets, Integer>{
	
	// save schrijft weg en Flush voor  voert wijzigingen meteen uit
	@Transactional
	Toets saveAndFlush(Toets newToets);

}
