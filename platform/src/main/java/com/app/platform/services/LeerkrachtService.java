package com.app.platform.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;
import com.app.platform.repos.LeerkrachtRepository;

@Service
public class LeerkrachtService implements ILeerkrachtService {
	
	@Autowired
	LeerkrachtRepository leerkrachtRepo;

	public void save(Leerkracht leerkracht) {
		leerkrachtRepo.save(leerkracht);		
	}


	public Leerkracht getLeerkracht(String id) {
		Optional<Leerkracht> l = leerkrachtRepo.findById(id);	
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}


	public List<Leerkracht> getAll() {
		return leerkrachtRepo.findAll();
	}
}
