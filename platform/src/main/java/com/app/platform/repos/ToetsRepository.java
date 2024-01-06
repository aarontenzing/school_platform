package com.app.platform.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.platform.model.Leerkracht;
import com.app.platform.model.Toets;


public interface ToetsRepository extends JpaRepository<Toets, Integer>{
	
	// save schrijft weg en Flush voor  voert wijzigingen meteen uit
	@SuppressWarnings("unchecked")
	@Transactional
	Toets saveAndFlush(Toets newToets);

	List<Toets> findAllByLeerkracht(Leerkracht l);

}