package com.app.platform.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;
import com.app.platform.repos.KlasRepository;

@Service
public class KlasService implements IKlasService{
	
	@Autowired
	KlasRepository klasRepo;
	
	public List<Leerling> getLeerlingen(String klasId) {
		return klasRepo.findLeerlingenByKlas(klasId);
	}

	public Klas getKlas(int id) {
		Optional<Klas> klas = klasRepo.findById(id);	
		if(klas.isPresent()) {
			return klas.get();
		}
		return null;
	}
	
}
