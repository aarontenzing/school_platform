package com.app.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Leerkracht;
import com.app.platform.model.Toets;
import com.app.platform.repos.ToetsRepository;

@Service
public class ToetsService implements IToetsService {
	
	@Autowired
	ToetsRepository toetsRepo;
	
	public Toets writeToets(String vaknaam, Leerkracht leerkracht) {
		Toets toets = new Toets(vaknaam, leerkracht);
		return toetsRepo.saveAndFlush(toets);
	}
	

}
