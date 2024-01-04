package com.app.platform.services;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.BoodschapLink;
import com.app.platform.model.Gebruiker;
import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;
import com.app.platform.repos.LeerkrachtRepository;

@Service
public class LeerkrachtService implements ILeerkrachtService {
	
	@Autowired
	LeerkrachtRepository LeerkrachtRepo;
	
	public List<Klas> findKlassen_van_leerkrachten(String id) {
		return LeerkrachtRepo.findKlassenByLeerkrachtId(id);
	}


	public void save(Leerkracht leerkracht) {
		LeerkrachtRepo.save(leerkracht);		
	}


	public Leerkracht getLeerkracht(String id) {
		Optional<Leerkracht> l = LeerkrachtRepo.findById(id);	
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}


	public List<Leerkracht> getAll() {
		return LeerkrachtRepo.findAll();
	}
}
