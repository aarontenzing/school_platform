package com.app.platform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;
import com.app.platform.repos.LeerlingRepository;

@Service
public class LeerlingService implements ILeerlingService {

	@Autowired
	LeerlingRepository leerlingRepo;

	public void save(Leerling leerling) {
		leerlingRepo.save(leerling);
	}

	public Leerling getLeerling(String id) {
		Optional<Leerling> l = leerlingRepo.findById(id);	
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}

	public List<Leerling> getAll() {
		return leerlingRepo.findAll();

	}
	
	public List<Leerling> getAllFromClass(Klas klas){
		return leerlingRepo.findByKlas(klas);
	}
}
